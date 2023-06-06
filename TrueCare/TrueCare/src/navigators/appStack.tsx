import React , { FC } from "react";
import { createStackNavigator } from "@react-navigation/stack";
import { Main , Home , Create , Login , Profile} from "../screens";

const { Navigator , Screen } = createStackNavigator();

const appStack : FC = () => {
    return (
        <Navigator>
            <Screen name="main" component={ Main } options={{headerShown: false}} />
            <Screen name="home" component={ Home } options={{headerShown: false}} />
            <Screen name="create" component={ Create } options={{headerShown: false}} />
            <Screen name="login" component={ Login } options={{headerShown: false}} />
            <Screen name="profile" component={ Profile } options={{headerShown: false}} />
        </Navigator>
    )
}

export default appStack;