import {TextField} from "@hilla/react-components/TextField";
import {Button} from "@hilla/react-components/Button";
import Project from "Frontend/generated/com/github/taefi/shepherdui/endpoints/shephered/dto/Project";
import {useForm, useFormPart} from "@hilla/react-form";
import ProjectModel from "Frontend/generated/com/github/taefi/shepherdui/endpoints/shephered/dto/ProjectModel";
import {ShepherdClientEndpoint} from "Frontend/generated/endpoints";
import {TextArea} from "@hilla/react-components/TextArea";
import React, {useEffect, useState} from "react";
import {RadioGroup} from "@hilla/react-components/RadioGroup";
import {RadioButton} from "@hilla/react-components/RadioButton";
import {useSsoContext} from "@hilla/sso-kit-client-react";
import {Notification} from "@hilla/react-components/Notification";
import {useNavigate} from "react-router-dom";
import {HorizontalLayout} from "@hilla/react-components/HorizontalLayout";
import {FormLayout} from "@hilla/react-components/FormLayout";

export default function ProjectEditorView () {
    const navigate = useNavigate();
    const {user} = useSsoContext();

    const projectBinder = useForm(ProjectModel, {
        onSubmit: async (project: Project)=> {
            project.publication!.https = isHttps;
            project.publication!.publishOnMainDomain = isPublishedOnMainDomain;
            project.publication!.additionalDomains = additionalDomains === "" ? [] : additionalDomains.split("\n");
            project.buildSpec!.buildArgs = convertMultilineTextToRecords(buildArgs);
            project.projectRuntime!.envVars = convertMultilineTextToRecords(envVars);

            await ShepherdClientEndpoint.createProject(project);
            Notification.show("Project created!");
            clearForm();
            navigateToProjectList();
        }
    });

    function convertMultilineTextToRecords(multiLineString: string) : Record<string, string> {
        const envVars: Record<string,string> = {};
        if (multiLineString !== "") {
            multiLineString.split("\n")
                     .forEach(line => {
                         const [key, value] = line.split("=");
                         envVars[key] = value;
                     });
        }
        return envVars;
    }

    function clearForm() {
        projectBinder.clear();
    }

    function navigateToProjectList() {
        navigate("/");
    }

    const [envVars, setEnvVars] = useState<string>("");
    const [buildArgs, setBuildArgs] = useState<string>("");
    const [additionalDomains, setAdditionalDomains] = useState<string>("");
    const [isHttps, setHttps] = useState<boolean>(true);
    const [isPublishedOnMainDomain, setPublishedOnMainDomain] = useState<boolean>(true);

    const ownerBinder = useFormPart(projectBinder.model.projectOwner);
    const repoBinder = useFormPart(projectBinder.model.gitRepo);
    const buildSpecBinder = useFormPart(projectBinder.model.buildSpec);
    const buildResourceBinder = useFormPart(buildSpecBinder.model.resources);
    const runtimeBinder = useFormPart(projectBinder.model.projectRuntime);
    const runtimeResourceBinder = useFormPart(runtimeBinder.model.resources);
    const publicationBinder = useFormPart(projectBinder.model.publication);

    useEffect(() => {
        const newEmptyProject = {
            ...projectBinder.defaultValue,
            projectOwner: {
                ...ownerBinder.defaultValue,
                email: user?.email,
                name: user?.fullName
            },
            gitRepo: {
                ...repoBinder.defaultValue,
                branch: "main"
            },
            buildSpec: {
                ...buildSpecBinder.defaultValue,
                resources: {
                    cpu: 2,
                    memoryMb: 1024
                },
                dockerFile: "./Dockerfile",
            },
            projectRuntime: {
                ...runtimeBinder.defaultValue,
                resources: {
                    cpu: 1,
                    memoryMb: 512
                }
            },
            publication: {
                https: true,
                publishOnMainDomain: true,
                additionalDomains: []
            }
        }
        projectBinder.read(newEmptyProject);

        setHttps(newEmptyProject.publication.https);
        setPublishedOnMainDomain(newEmptyProject.publication.publishOnMainDomain);
    }, []);

    return (
        <section className="flex flex-col p-m gap-m items-start">
            <h2>New project</h2>
            <section className="flex flex-col gap-s" style={{width: '50%'}}>
                <TextField
                    label="Project description"
                    {...projectBinder.field(projectBinder.model.description)}
                />
                <TextField
                    label="Webpage"
                    {...projectBinder.field(projectBinder.model.webpage)}
                />
            </section>
            <section className="flex flex-col gap-s w-full">
                <h4>Owner</h4>
                <section className="flex flex-row flex-wrap gap-s" style={{width: '50%'}}>
                    <TextField
                        label="Owner"
                        style={{flexGrow: 1}}
                        {...ownerBinder.field(ownerBinder.model.name)}
                    />
                    <TextField
                        label="Email"
                        style={{flexGrow: 1}}
                        {...ownerBinder.field(ownerBinder.model.email)}
                    />
                </section>
            </section>
            <section className="flex flex-col gap-s w-full">
                <h4>Git repository</h4>
                <section className="flex flex-row flex-wrap gap-s" style={{width: '50%'}}>
                    <TextField
                        label="Git url"
                        style={{flexGrow: 5}}
                        {...repoBinder.field(repoBinder.model.url)}
                    />
                    <TextField
                        label="Git branch"
                        style={{flexGrow: 0.25}}
                        {...repoBinder.field(repoBinder.model.branch)}
                    />
                </section>
            </section>
            <section className="flex flex-col gap-s w-full">
                <h4>Build specification</h4>
                <section className="flex flex-col gap-s w-full">
                    <section className="flex flex-row flex-wrap gap-s" style={{width: '50%'}}>
                        <TextField label="Dockerfile path"
                                   style={{flexGrow: 1}}
                                   {...buildSpecBinder.field(buildSpecBinder.model.dockerFile)} />
                        <TextArea
                            label="Build Arguments (one per line)"
                            style={{flexGrow: 1}}
                            onValueChanged={e => setBuildArgs(e.detail.value)}/>
                    </section>
                    <section className="flex flex-row flex-wrap gap-s" style={{width: '50%'}}>
                        <TextField
                            label="Number of CPUs"
                            style={{flexGrow: 1}}
                            {...buildResourceBinder.field(buildResourceBinder.model.cpu)}
                            disabled />
                        <TextField
                            label="Memory (MB)"
                            style={{flexGrow: 1}}
                            {...buildResourceBinder.field(buildResourceBinder.model.memoryMb)}
                            disabled />
                    </section>
                </section>
            </section>
            <section className="flex flex-col gap-s w-full">
                <h4>Runtime specification</h4>
                <section className="flex flex-row flex-wrap gap-s" style={{width: '50%'}}>
                    <TextArea
                        label="Environment variables (one per line)"
                        style={{flexGrow: 40}}
                        onValueChanged={e => setEnvVars(e.detail.value)}
                    />
                    <TextField
                        label="Number of CPUs"
                        style={{flexGrow: 0.0}}
                        {...runtimeResourceBinder.field(runtimeResourceBinder.model.cpu)}
                        disabled />
                    <TextField
                        label="Memory (MB)"
                        style={{flexGrow: 0.0}}
                        {...runtimeResourceBinder.field(runtimeResourceBinder.model.memoryMb)}
                        disabled />
                </section>
            </section>
            <section className="flex flex-col gap-s w-full">
                <h4>Publication</h4>
                <section className="flex flex-row flex-wrap gap-xl" style={{width: '50%'}}>
                    <RadioGroup label={"Https?"}
                                onValueChanged={e => setHttps(e.detail.value === "true")}
                                value={isHttps + ""}
                                disabled>
                        <RadioButton label="Yes" value="true" />
                        <RadioButton label="No" value="false" />
                    </RadioGroup>
                    <RadioGroup label={"Publish on main domain?"}
                                onValueChanged={e => setPublishedOnMainDomain(e.detail.value === "true")}
                                value={isPublishedOnMainDomain + ""}
                                disabled>
                        <RadioButton label="Yes" value="true" />
                        <RadioButton label="No" value="false" />
                    </RadioGroup>
                    <TextArea
                        label="Additional domains (one per line)"
                        style={{flexGrow: 1}}
                        onValueChanged={e => setAdditionalDomains(e.detail.value)}
                        disabled />
                </section>
            </section>

            <section className="flex flex-row flex-wrap gap-xl" style={{width: '50%'}}>
                <Button
                    theme="primary"
                    onClick={projectBinder.submit}
                    disabled={!projectBinder.dirty}
                >
                    Save project
                </Button>
                <Button
                    onClick={projectBinder.reset}
                    disabled={!projectBinder.dirty}
                >
                    Cancel
                </Button>
            </section>
        </section>
    )
}