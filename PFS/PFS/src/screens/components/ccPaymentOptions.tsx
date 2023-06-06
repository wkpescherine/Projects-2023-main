import React , { FC } from "react";
import { View , Text, Button } from "react-native";
import { useNavigation } from "@react-navigation/native";
import mainStyle from "../../stylesheets/mainStyleSheet"
import { StatusBar } from "expo-status-bar";

const App : FC = () => {
    const navigation = useNavigation();

    return(
        <><StatusBar hidden />
            <View style={mainStyle.horizonFlow}>
                <Button title="Minimum"/>
                <Button title="15%"/>
                <Button title="25%"/>
                <Button title="50%"/>
                <Button title="Full"/>
            </View>
        </>
    )
}

export default App;