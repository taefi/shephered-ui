import {AutoCrud} from "@hilla/react-crud";
import {ProjectService, ProjectViewService} from "Frontend/generated/endpoints";
import ProjectModel from "Frontend/generated/com/github/taefi/shepherdui/endpoints/shephered/dto/ProjectModel";
import {GridColumn} from "@hilla/react-components/GridColumn";
import Project from "Frontend/generated/com/github/taefi/shepherdui/endpoints/shephered/dto/Project";


export default function ProjectsCRUD () {

    const ownerRenderer = ({item}: {item: Project}) => {
        return <span>{item.projectOwner?.name} - {item.projectOwner?.email}</span>
    }

    const gitRepoRenderer = ({item}: {item: Project}) => {
        return <span>{item.gitRepo?.url}: {item.gitRepo?.branch}</span>
    }

    return (
        <AutoCrud service={ProjectService} model={ProjectModel}
            gridProps={{
                visibleColumns: ['description'],
                customColumns: [
                    <GridColumn key='owner-col' header='Owner' renderer={ownerRenderer} />,
                    <GridColumn key='git-repo-col' header='Git Repo: Branch' renderer={gitRepoRenderer} />
                ],
                columnOptions: {
                    description: {
                        header: 'Project',
                    }
                }
            }}
        />
    );
}