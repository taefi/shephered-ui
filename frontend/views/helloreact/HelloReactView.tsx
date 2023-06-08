import { Button } from '@hilla/react-components/Button.js';
import { Notification } from '@hilla/react-components/Notification.js';
import { TextField } from '@hilla/react-components/TextField.js';
import {HelloReactEndpoint, ShepherdClientEndpoint} from 'Frontend/generated/endpoints.js';
import { useState } from 'react';
import {Grid} from "@hilla/react-components/Grid";
import {GridColumn} from "@hilla/react-components/GridColumn";
import ProjectView from "Frontend/generated/com/github/taefi/shepherdui/endpoints/shephered/dto/ProjectView";
import Project from "Frontend/generated/com/github/taefi/shepherdui/endpoints/shephered/dto/Project";
import gitRepo from "Frontend/generated/com/github/taefi/shepherdui/endpoints/shephered/dto/GitRepo";


export default function HelloReactView() {
  //Project DTO to be modified by the form.
  const [project, setProject] = useState<Project>({});

  //Project properties
  const [projectDescription, setProjectDescription] = useState<string>('');
  const [projectWebpage, setProjectWebpage] = useState<string>('');
  const [gitUrl, setGitUrl] = useState<string>('');
  const [gitBranch, setGitBranch] = useState<string>('');

  //For grid
  const [projects, setProjects] = useState<ProjectView[]>(new Array<ProjectView>());
  const [selectedProject, setSelectedProject] = useState<ProjectView[]>(new Array<ProjectView>());

  useState(async () => {
      setProjects(await ShepherdClientEndpoint.getProjects(''));
  })

    return (
    <section className="flex flex-row">
      <section className="flex flex-col p-m gap-m items-end">
        <TextField
            value={projectDescription}
            onValueChanged={e => setProjectDescription(e.detail.value)}
          label="Project description"
        />
          <TextField
              value={projectWebpage}
              onValueChanged={e => setProjectWebpage(e.detail.value)}
              label="Webpage"
          />
          <TextField
              value={gitUrl}
              onValueChanged={e => setGitUrl(e.detail.value)}
              label="Git url"
          />

          <TextField
              value={gitBranch}
              onValueChanged={e => setGitBranch(e.detail.value)}
              label="Git branch"
          />
        <Button
          onClick={async () => {
              project.description = projectDescription;
              project.webpage = projectWebpage;
              if (project.gitRepo == undefined) {
                  project.gitRepo = {};
              }
              project.gitRepo.branch = gitBranch;
              project.gitRepo.url = gitUrl;
              await ShepherdClientEndpoint.createProject(project);
          }}
        >
          Create project
        </Button>
      </section>

      <Grid items={projects}
            selectedItems={selectedProject}
            onActiveItemChanged={({ detail: { value } }) => {
                    setProject(value ? value.project ? value.project : {} : {});
                    setProjectDescription(project?.description || '');
                    setProjectWebpage(project?.webpage || '');
                    setGitUrl(project?.gitRepo?.url || '');
                    setGitBranch(project?.gitRepo?.branch || '');
                }
            }
      >
          <GridColumn header="Project">
              {({ item }) => <>{item.project.description}</>}
          </GridColumn>

          <GridColumn header="Webpage">
              {({ item }) => <>{item.project.webpage}</>}
          </GridColumn>

          <GridColumn header="Owner">
              {({ item }) => <>{item.project.owner?.name} {item.project.owner?.email}</>}
          </GridColumn>

          <GridColumn header="Gitrepo">
              {({ item }) => <>{item.project.gitRepo?.url} {item.project.gitRepo?.branch}</>}
          </GridColumn>
      </Grid>
    </section>
  );

}
