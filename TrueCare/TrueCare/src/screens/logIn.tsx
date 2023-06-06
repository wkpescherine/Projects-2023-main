import React , { FC } from "react";
import { View , TextInput , Button , StyleSheet } from "react-native";
import { useNavigation } from "@react-navigation/native";
import container from "../Stylesheets/containers"

const App : FC = () => {
    const navigation = useNavigation();

    return(
        <View style={container.container}>
            <TextInput style={container.inputContainer}
                placeholder="Username" 
            />
            <TextInput style={container.inputContainer}
                placeholder="Password" 
            />
            <View style={container.horizontal}>
                <Button title="Log-In" onPress={()=>navigation.navigate("home")}/>
            </View>
            <View style={container.horizontal}>
                <Button title="Back" onPress={()=>navigation.navigate("main")}/>
            </View>
        </View>
    )
}

export default App;