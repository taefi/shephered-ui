import { Button } from '@hilla/react-components/Button.js';
import { Notification } from '@hilla/react-components/Notification.js';
import { TextField } from '@hilla/react-components/TextField.js';
import {HelloReactEndpoint, ShepherdClientEndpoint} from 'Frontend/generated/endpoints.js';
import { useState } from 'react';
import {Grid} from "@hilla/react-components/Grid";
import {GridColumn} from "@hilla/react-components/GridColumn";
import Data from "Frontend/generated/com/github/taefi/shepherdui/endpoints/shephered/ShepherdClientEndpoint/Data";


export default function HelloReactView() {
  const [name, setName] = useState('');
  const [data, setData] = useState<Data[]>(new Array<Data>());

  useState(async () => {
      setData(await ShepherdClientEndpoint.getData());
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

          <Grid items={data}>
              <GridColumn path="name"></GridColumn>
              <GridColumn path="org"></GridColumn>
          </Grid>
      </section>
    </>
  );

}
