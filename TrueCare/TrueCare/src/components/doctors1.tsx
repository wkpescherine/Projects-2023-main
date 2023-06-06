import React , { FC } from "react";
import { View , Text, Button , StyleSheet} from "react-native";
import containers from "../Stylesheets/containers"

const selectDoctor = (doc) =>{

}

const App : FC = () => {
    function selectDoctor(doc){
        console.log(doc);
    }
    return(
        <View style={containers.horizonFlow}>
            <View style={containers.containerButton}>
                <Button onPress={()=>selectDoctor("Pediatrician")} title="Pediatrician"/>
            </View>
            <View style={containers.containerButton}>
                <Button onPress={()=>selectDoctor("Family")} title="Family"/>
            </View>
            <View style={containers.containerButton}>
                <Button onPress={()=>selectDoctor("Dentist")} title="Dentist"/>
            </View>
        </View>
    )
}

export default App;