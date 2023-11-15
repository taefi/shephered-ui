import ProjectsView from 'Frontend/views/projects/ProjectsView';
import MainLayout from 'Frontend/views/MainLayout.js';
import { lazy } from 'react';
import { createBrowserRouter, IndexRouteObject, NonIndexRouteObject, useMatches } from 'react-router-dom';
import { AccessProps, protectRoutes } from "@hilla/sso-kit-client-react";
import ProjectEditorView from "Frontend/views/projects/ProjectEditorView";
import ProjectsCRUD from "Frontend/views/projects/ProjectsCRUD";

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

export const routes: readonly ViewRouteObject[] = protectRoutes([
  {
    element: <MainLayout />, handle: { title: 'Main' },
    children: [
      { path: '/', element: <ProjectsView />, handle: { icon: 'globe-solid', title: 'Projects' } },
      { path: '/new', element: <ProjectEditorView />, handle: { icon: 'globe-solid', title: 'New Project' }, requireAuthentication: true },
      { path: '/about', element: <AboutView />, handle: { icon: 'file', title: 'About' }, requireAuthentication: true },
      { path: '/crud', element: <ProjectsCRUD />, handle: { icon: 'file', title: 'CRUD' }, requireAuthentication: true },
    ],
  }
]);

const router = createBrowserRouter([...routes]);
export default router;
