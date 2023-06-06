import React , { FC } from "react";
import { View , Text, Button , StyleSheet} from "react-native";
import { useNavigation } from "@react-navigation/native";
import styles from "../Stylesheets/containers"

const App : FC = () => {
    const navigation = useNavigation();

    return(
        <View style={styles.container}>
            <Text>Welcome to TrueCare</Text>
            <Button title="Log-Out" onPress={()=>navigation.navigate("main")}/>
            <Button title="Profile" onPress={()=>navigation.navigate("profile")}/>
        </View>
    )
}

export default App;