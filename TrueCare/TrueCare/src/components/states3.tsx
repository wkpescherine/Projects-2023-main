import React , { FC } from "react";
import { View , Text, Button , StyleSheet} from "react-native";
import containers from "../Stylesheets/containers"

const App : FC = () => {
    return(
        <View style={containers.horizonFlow}>
            <View style={containers.containerButton}>
                <Button title="KS"/>
            </View>
            <View style={containers.containerButton}>
                <Button title="KY"/>
            </View>
            <View style={containers.containerButton}>
                <Button title="LA"/>
            </View>
            <View style={containers.containerButton}>
                <Button title="MA"/>
            </View>
            <View style={containers.containerButton}>
                <Button title="ME"/>
            </View>
            <View style={containers.containerButton}>
                <Button title="MD"/>
            </View>
            <View style={containers.containerButton}>
                <Button title="MO"/>
            </View>
        </View>
    )
}

export default App;