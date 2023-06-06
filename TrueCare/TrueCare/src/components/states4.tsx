import React , { FC } from "react";
import { View , Text, Button , StyleSheet} from "react-native";
import containers from "../Stylesheets/containers"

const App : FC = () => {
    return(
        <View style={containers.horizonFlow}>
            <View style={containers.containerButton}>
                <Button title="MI"/>
            </View>
            <View style={containers.containerButton}>
                <Button title="MN"/>
            </View>
            <View style={containers.containerButton}>
                <Button title="MS"/>
            </View>
            <View style={containers.containerButton}>
                <Button title="MT"/>
            </View>
            <View style={containers.containerButton}>
                <Button title="NC"/>
            </View>
            <View style={containers.containerButton}>
                <Button title="NE"/>
            </View>
            <View style={containers.containerButton}>
                <Button title="ND"/>
            </View>
        </View>
    )
}

export default App;