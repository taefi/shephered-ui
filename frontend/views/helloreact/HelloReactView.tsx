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
  const [project, setProject] = useState<Project>({});
  const [projectDescription, setProjectDescription] = useState<string>('');
  const [projects, setProjects] = useState<ProjectView[]>(new Array<ProjectView>());
  const [selectedProject, setSelectedProject] = useState<ProjectView[]>(new Array<ProjectView>());

  useState(async () => {
      setProjects(await ShepherdClientEndpoint.getProjects('samuli@vaadin.com'));
  })

    return (
    <>
      <section className="flex p-m gap-m items-end">
        <TextField
            value={projectDescription}
          label="Your name"
        />
        <Button
          onClick={async () => {
              project.description = projectDescription;
              console.log('project.description='+project.description);
              console.log('projectDescription='+projectDescription);
              await ShepherdClientEndpoint.createProject(project);
          }}
        >
          Say hello
        </Button>

          <Grid items={projects}
                selectedItems={selectedProject}
                onActiveItemChanged={({ detail: { value } }) => {
                    setProject(value ? value.project ? value.project : {} : {});
                    setProjectDescription(project.description?project.description:'');
                    console.log('changed selected items' + project.description);
                }
                }
          >
              <GridColumn header="Project">
                  {({ item }) => <>{item.project.description}</>}
              </GridColumn>
          </Grid>
      </section>
    </>
  );

}
