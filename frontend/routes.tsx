import HelloReactView from 'Frontend/views/helloreact/HelloReactView.js';
import MainLayout from 'Frontend/views/MainLayout.js';
import { lazy } from 'react';
import { createBrowserRouter, IndexRouteObject, NonIndexRouteObject, useMatches } from 'react-router-dom';
import { AccessProps } from './useAuth';

const AboutView = lazy(async () => import('Frontend/views/about/AboutView.js'));
export type MenuProps = Readonly<{
  icon?: string;
  title?: string;
}>;

export type ViewMeta = Readonly<{ handle?: MenuProps }>;

type Override<T, E> = Omit<T, keyof E> & E;

export type IndexViewRouteObject = Override<IndexRouteObject, ViewMeta>;
export type NonIndexViewRouteObject = Override<
  Override<NonIndexRouteObject, ViewMeta>,
  {
    children?: ViewRouteObject[];
  }
>;
// Enrich the ViewRouteObject type with AccessProps.
export type ViewRouteObject = (IndexViewRouteObject | NonIndexViewRouteObject) & AccessProps;

type RouteMatch = ReturnType<typeof useMatches> extends (infer T)[] ? T : never;

export type ViewRouteMatch = Readonly<Override<RouteMatch, ViewMeta>>;

export const useViewMatches = useMatches as () => readonly ViewRouteMatch[];

export const routes: readonly ViewRouteObject[] = [
  {
    element: <MainLayout />,
    handle: { icon: 'null', title: 'Main' },
    children: [
      { path: '/', element: <HelloReactView />, handle: { icon: 'globe-solid', title: 'Hello React' } },
      { path: '/about', element: <AboutView />, handle: { icon: 'file', title: 'About' }, requiresLogin: true },
    ],
  },
];

const router = createBrowserRouter([...routes]);
export default router;
