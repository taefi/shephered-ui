import { AppLayout } from '@hilla/react-components/AppLayout.js';
import { Avatar } from '@hilla/react-components/Avatar.js';
import { Button } from '@hilla/react-components/Button.js';
import { DrawerToggle } from '@hilla/react-components/DrawerToggle.js';
import Placeholder from 'Frontend/components/placeholder/Placeholder';
import { useSsoContext } from "@hilla/sso-kit-client-react";
import { useRouteMetadata } from 'Frontend/util/routing';
import { Suspense } from 'react';
import { NavLink, Outlet } from 'react-router-dom';

const navLinkClasses = ({ isActive }: any) => {
  return `block rounded-m p-s ${isActive ? 'bg-primary-10 text-primary' : 'text-body'}`;
};

export default function MainLayout() {
  const currentTitle = useRouteMetadata()?.title ?? 'My App';
  const {authenticated, user, login, logout} = useSsoContext();
  return (
    <AppLayout primarySection="drawer">
      <div slot="drawer" className="flex flex-col justify-between h-full p-m">
        <header className="flex flex-col gap-m">
          <h1 className="text-l m-0">My App</h1>
          <nav>
            {authenticated ? (
              <NavLink className={navLinkClasses} to="/">
                Projects
              </NavLink>
            ) : null}
            {authenticated ? (
              <NavLink className={navLinkClasses} to="/about">
                About
              </NavLink>
            ) : null}
            {authenticated ? (
              <NavLink className={navLinkClasses} to="/crud">
                CRUD
              </NavLink>
            ) : null}
          </nav>
        </header>
        <footer className="flex flex-col gap-s">
          {authenticated ? (
            <>
              <div className="flex items-center gap-s">
                {user?.fullName}
              </div>
              <Button onClick={logout}>Sign out</Button>
            </>
          ) : (
              <Button onClick={login}>Sign in</Button>
          )}
        </footer>
      </div>

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
