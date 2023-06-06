import React , { FC } from "react";
import { View , Text, Button , StyleSheet} from "react-native";
import containers from "../Stylesheets/containers"

const App : FC = () => {
    return(
        <View style={containers.horizonFlow}>
            <View style={containers.containerButton}>
                <Button title="OK"/>
            </View>
            <View style={containers.containerButton}>
                <Button title="PA"/>
            </View>
            <View style={containers.containerButton}>
                <Button title="RI"/>
            </View>
            <View style={containers.containerButton}>
                <Button title="SC"/>
            </View>
            <View style={containers.containerButton}>
                <Button title="SD"/>
            </View>
            <View style={containers.containerButton}>
                <Button title="TN"/>
            </View>
            <View style={containers.containerButton}>
                <Button title="TX"/>
            </View>
        </View>
    )
}

export default App;