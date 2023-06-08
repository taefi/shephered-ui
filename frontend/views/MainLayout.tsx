import { AppLayout } from '@hilla/react-components/AppLayout.js';
import { DrawerToggle } from '@hilla/react-components/DrawerToggle.js';
import { Item } from '@hilla/react-components/Item.js';
import { Scroller } from '@hilla/react-components/Scroller.js';
import Placeholder from 'Frontend/components/placeholder/Placeholder.js';
import { MenuProps, routes, useViewMatches, ViewRouteObject } from 'Frontend/routes.js';
import { logout } from '@hilla/frontend';
import { Button } from '@hilla/react-components/Button.js';
import { AuthContext } from 'Frontend/useAuth';
import { Suspense, useContext } from 'react';
import { NavLink, Outlet } from 'react-router-dom';
import css from './MainLayout.module.css';

type MenuRoute = ViewRouteObject &
  Readonly<{
    path: string;
    handle: Required<MenuProps>;
  }>;

export default function MenuOnLeftLayout() {

  const { state, hasAccess } = useContext(AuthContext);

  async function signOut() {
      await logout(); // Logout on the server
      location.href = state.logoutLink!;
  }

  function signIn() {
      location.href = state.loginLink;
  }

  const matches = useViewMatches();

  const currentTitle = matches[matches.length - 1]?.handle?.title ?? 'Unknown';

  const menuRoutes = (routes[0]?.children || []).filter(
    (route) => route.path && route.handle && route.handle.icon && route.handle.title
  ) as readonly MenuRoute[];

  return (
    <AppLayout className="block h-full" primarySection="drawer">
      <header slot="drawer">
        <h1 className="text-l m-0">My App</h1>
      </header>
      <Scroller slot="drawer" scroll-direction="vertical">
        <nav>
          {menuRoutes.filter(hasAccess).map(({ path, handle: { icon, title } }) => (
            <NavLink
              className={({ isActive }) => `${css.navlink} ${isActive ? css.navlink_active : ''}`}
              key={path}
              to={path}
            >
              {({ isActive }) => (
                <Item key={path} selected={isActive}>
                  <span
                    className={css.navicon}
                    style={
                      {
                        '--mask-image': `url('line-awesome/svg/${icon}.svg')`,
                        maskImage: 'var(--mask-image)',
                        WebkitMaskImage: 'var(--mask-image)',
                      } as any
                    }
                    aria-hidden="true"
                  ></span>
                  {title}
                </Item>
              )}
            </NavLink>
          ))}
        </nav>
      </Scroller>

      <footer slot="drawer">
        {state.authenticated
          ? <Button onClick={signOut}>Sign out</Button>
          : <Button onClick={signIn}>Sign in</Button>
        }
      </footer>

      <DrawerToggle slot="navbar" aria-label="Menu toggle"></DrawerToggle>
      <h2 slot="navbar" className="text-l m-0">
        {currentTitle}
      </h2>

      <Suspense fallback={<Placeholder />}>
        <Outlet />
      </Suspense>
    </AppLayout>
  );
}
