import React , { FC } from "react";
import { View , Text, Button , StyleSheet} from "react-native";
import containers from "../Stylesheets/containers"

const App : FC = () => {
    return(
        <View style={containers.horizonFlow}>
            <View style={containers.containerButton}>
                <Button title="FL"/>
            </View>
            <View style={containers.containerButton}>
                <Button title="GA"/>
            </View>
            <View style={containers.containerButton}>
                <Button title="HI"/>
            </View>
            <View style={containers.containerButton}>
                <Button title="IA"/>
            </View>
            <View style={containers.containerButton}>
                <Button title="ID"/>
            </View>
            <View style={containers.containerButton}>
                <Button title="IL"/>
            </View>
            <View style={containers.containerButton}>
                <Button title="IN"/>
            </View>
        </View>
    )
}

export default App;