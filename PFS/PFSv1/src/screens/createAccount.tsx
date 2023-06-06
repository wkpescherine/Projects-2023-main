import React , { FC, useState } from "react";
import { View , Text, Button, TextInput } from "react-native";
import { useNavigation } from "@react-navigation/native";
//import containers from "../Stylesheets/containers"
import mainStyle from "../stylesheets/mainStyleSheet"
import { StatusBar } from "expo-status-bar";
import AsyncStorage from "@react-native-async-storage/async-storage"

const App : FC = () => {
    const navigation = useNavigation();

    const [newUserName, setNewUserName] = useState("")
    const [newPassword, setNewPassword] = useState("")
    const [confirmUsername, setConfirmUserName] = useState("")
    const [confirmPassworc, setConfirmPassword] = useState("")

    const saveData = async() =>{
        try{
            console.log("was here")
            await AsyncStorage.setItem('username', newUserName);
            await AsyncStorage.setItem('password', newPassword);
            await AsyncStorage.setItem('wealth', "0" );
            await AsyncStorage.setItem('status', "Active" );
            navigation.navigate("dashboard")
        }catch (e) {
            alert("Failed")
        }
    }

    return(
        <><StatusBar hidden />
            <View style={mainStyle.container}>
                <Text style={mainStyle.basicText}>Create New Account</Text>
                <View>
                        <TextInput 
                            style={mainStyle.inputTextStyle}
                            placeholder="Enter new username" 
                            onChangeText={text=>setNewUserName(text)}
                            value={newUserName}
                            />
                        <TextInput 
                            style={mainStyle.inputTextStyle}
                            placeholder="Enter new password" 
                            onChangeText={text=>setNewPassword(text)}
                            value={newPassword}/>
                        <TextInput 
                            style={mainStyle.inputTextStyle}
                            placeholder="Confirm new username" 
                            onChangeText={text=>setConfirmUserName(text)}
                            value={confirmUsername}
                            />
                        <TextInput 
                            style={mainStyle.inputTextStyle}
                            placeholder="Confirm new password" 
                            onChangeText={text=>setConfirmPassword(text)}
                            value={confirmPassworc}/>
                    </View>
                {newUserName === confirmUsername &&
                newPassword === confirmPassworc &&
                newPassword !== "" &&
                    <Button title="Create Account" onPress={() => saveData()}/>
                }
                <Button title="Back to Main" onPress={() => navigation.navigate("main")}/>
            </View>
        </>
    )
}

export default App;