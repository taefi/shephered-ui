import router from 'Frontend/routes.js';
import { SsoProvider } from "@hilla/sso-kit-client-react";
import { RouterProvider } from 'react-router-dom';

export default function App() {
  return (
      <SsoProvider>
          <RouterProvider router={router}/>
      </SsoProvider>
  );
}
