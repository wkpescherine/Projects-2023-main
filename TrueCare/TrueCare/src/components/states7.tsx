import React , { FC } from "react";
import { View , Text, Button , StyleSheet} from "react-native";
import containers from "../Stylesheets/containers"

const App : FC = () => {
    return(
        <View style={containers.horizonFlow}>
            <View style={containers.containerButton}>
                <Button title="UT"/>
            </View>
            <View style={containers.containerButton}>
                <Button title="VA"/>
            </View>
            <View style={containers.containerButton}>
                <Button title="VT"/>
            </View>
            <View style={containers.containerButton}>
                <Button title="WA"/>
            </View>
            <View style={containers.containerButton}>
                <Button title="WI"/>
            </View>
            <View style={containers.containerButton}>
                <Button title="WV"/>
            </View>
            <View style={containers.containerButton}>
                <Button title="WY"/>
            </View>
        </View>
    )
}

export default App;