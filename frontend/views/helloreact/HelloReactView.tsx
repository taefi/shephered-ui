import { Button } from '@hilla/react-components/Button.js';
import { Notification } from '@hilla/react-components/Notification.js';
import { TextField } from '@hilla/react-components/TextField.js';
import {HelloReactEndpoint, ShepherdClientEndpoint} from 'Frontend/generated/endpoints.js';
import { useState } from 'react';
import {Grid} from "@hilla/react-components/Grid";
import {GridColumn} from "@hilla/react-components/GridColumn";
import Data from "Frontend/generated/com/github/taefi/shepherdui/endpoints/shephered/ShepherdClientEndpoint/Data";
import ProjectView from "Frontend/generated/com/github/taefi/shepherdui/endpoints/shephered/dto/ProjectView";
import Project from "Frontend/generated/com/github/taefi/shepherdui/endpoints/shephered/dto/Project";


export default function HelloReactView() {
  const [name, setName] = useState('');
  const [data, setData] = useState<Data[]>(new Array<Data>());
  const [projects, setProjects] = useState<ProjectView[]>(new Array<ProjectView>());

  useState(async () => {
      setData(await ShepherdClientEndpoint.getData());
      setProjects(await ShepherdClientEndpoint.getProjects('samuli@vaadin.com'));
  })
  return (
    <>
      <section className="flex p-m gap-m items-end">
        <TextField
          label="Your name"
          onValueChanged={(e) => {
            setName(e.detail.value);
          }}
        />
        <Button
          onClick={async () => {
            const serverResponse = await HelloReactEndpoint.sayHello(name);

            setData(((await ShepherdClientEndpoint.getData())));
            Notification.show(serverResponse);
          }}
        >
          Say hello
        </Button>

          <Grid items={projects}>
              <GridColumn path="name"></GridColumn>
              <GridColumn path="org"></GridColumn>
              <GridColumn header="Project">
                  {({ item }) => <>{item.project.description}</>}
              </GridColumn>
          </Grid>
      </section>
    </>
  );

}
