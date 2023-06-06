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
                <Text style={mainStyle.basicText}>Stock Market</Text>
                <Button title=">" onPress={() => navigation.navigate("stockmarket")}/>
            </View>
        </>
    )
}

export default App;