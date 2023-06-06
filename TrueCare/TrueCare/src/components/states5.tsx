import React , { FC } from "react";
import { View , Text, Button , StyleSheet} from "react-native";
import containers from "../Stylesheets/containers"

const App : FC = () => {
    return(
        <View style={containers.horizonFlow}>
            <View style={containers.containerButton}>
                <Button title="NH"/>
            </View>
             <View style={containers.containerButton}>
                <Button title="NJ"/>
            </View>
            <View style={containers.containerButton}>
                <Button title="NM"/>
            </View>
            <View style={containers.containerButton}>
                <Button title="NV"/>
            </View>
            <View style={containers.containerButton}>
                <Button title="NY"/>
            </View>
            <View style={containers.containerButton}>
                <Button title="OR"/>
            </View>
            <View style={containers.containerButton}>
                <Button title="OH"/>
            </View>
        </View>
    )
}

export default App;