import React , { FC } from "react";
import { View , Text, Button , StyleSheet} from "react-native";
import { useNavigation } from "@react-navigation/native";
import styles from "../Stylesheets/containers"

const App : FC = () => {
    const navigation = useNavigation();

    return(
        <View style={styles.container}>
            <Text>UserName </Text>
            <Button title="Back to Main" onPress={()=>navigation.navigate("home")}/>
        </View>
    )
}

export default App;