import User from "Frontend/generated/dev/hilla/sso/starter/endpoint/User";
import { UserEndpoint } from "Frontend/generated/endpoints";
import { useEffect, useState } from "react";
import {Grid} from "@hilla/react-components/Grid";
import {GridColumn} from "@hilla/react-components/GridColumn";
import ProjectView from "Frontend/generated/com/github/taefi/shepherdui/endpoints/shephered/dto/ProjectView";

export default function AboutView() {

    // Store the authenticated user.
    const [user, setUser] = useState<User | undefined>();
    const [projects, setProjects] = useState<Array<ProjectView>>();
    // Fetch the authenticated user from the server.
    useEffect(() => {
        UserEndpoint.getAuthenticatedUser().then(setUser);

    }, []);

  return (
    <div className="flex flex-col h-full items-center justify-center p-l text-center box-border">
      <img style={{ width: '200px' }} src="images/empty-plant.png" />
        <p>Username: {user?.preferredUsername}</p>
        <p>Full name: {user?.fullName}</p>
        <p>Email: {user?.email}</p>
    </div>
      /*<Grid items={fruits}>
          <GridColumn path="name" />
          <GridColumn path="quantity" />
      </Grid>*/
  );
}
