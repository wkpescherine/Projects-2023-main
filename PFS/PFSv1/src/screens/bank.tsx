import React , { FC } from "react";
import { View , Text, Button } from "react-native";
import { useNavigation } from "@react-navigation/native";
//import containers from "../Stylesheets/containers"
import mainStyle from "../stylesheets/mainStyleSheet"
import { StatusBar } from "expo-status-bar";

const App : FC = () => {
    const navigation = useNavigation();

    return(
        <><StatusBar hidden />
            <View style={mainStyle.container}>
                <Text style={mainStyle.basicText}>Bank Section</Text>
                <Button title="Back to Dashboard" onPress={() => navigation.navigate("dashboard")}/>
            </View>
        </>
    )
}

export default App;