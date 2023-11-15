import {Button} from '@hilla/react-components/Button.js';
import {ProjectViewService} from 'Frontend/generated/endpoints.js';
import {useState} from 'react';
import {GridColumn} from "@hilla/react-components/GridColumn";
import ProjectView from "Frontend/generated/com/github/taefi/shepherdui/endpoints/shephered/dto/ProjectView";
import {HorizontalLayout} from "@hilla/react-components/HorizontalLayout";
import {useSsoContext} from "@hilla/sso-kit-client-react";
import {useNavigate} from "react-router-dom";
import {AutoGrid} from "@hilla/react-crud";
import ProjectViewModel from "Frontend/generated/com/github/taefi/shepherdui/endpoints/shephered/dto/ProjectViewModel";


export default function ProjectsView() {
  const {authenticated, user, login, logout} = useSsoContext();
  const navigate = useNavigate();

  const [selectedProjects, setSelectedProjects] = useState<ProjectView[]>(new Array<ProjectView>());

  return (
    <section className="flex flex-col h-full">
        <HorizontalLayout theme="spacing padding" style={{justifyContent: 'end'}}>
            <Button theme="primary" disabled={!authenticated} onClick={() => navigate("/new")}>New</Button>
            <Button theme="secondary" disabled={!authenticated}>Edit</Button>
            <Button theme="error" disabled={true}>Delete</Button>
        </HorizontalLayout>

        <AutoGrid
            service={ProjectViewService}
            model={ProjectViewModel}
            theme="row-stripes"
            customColumns={[
                <GridColumn header="Project">
                    {({ item }) => <>{item.project.description}</>}
                </GridColumn>,
                <GridColumn header="Last build">
                    {({ item }) => <>{
                        '#' + item.lastBuild?.number + ', status: ' + item.lastBuild.outcome}
                    </>}
                </GridColumn>,
                <GridColumn header="Owner">
                    {({ item }) => <>{item.project.projectOwner.email}</>}
                </GridColumn>,
                <GridColumn header="Gitrepo : branch">
                    {({ item }) => <>{item.project.gitRepo?.url} : {item.project.gitRepo?.branch}</>}
                </GridColumn>
            ]}
            selectedItems={selectedProjects}
                onActiveItemChanged={({ detail: { value } }) => {
                    const selected = value ? value.project ? value.project : {} : {};
                    setSelectedProjects(value ? [value] : []);
                }
            }
        />

    </section>
  );

}
