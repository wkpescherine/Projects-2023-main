import React , { FC, useState , useEffect } from "react";
import { View , Text, Button, TextInput } from "react-native";
import { useIsFocused, useNavigation } from "@react-navigation/native";
import mainStyle from "../stylesheets/mainStyleSheet"
import { StatusBar } from "expo-status-bar";
import AsyncStorage from "@react-native-async-storage/async-storage"

const App : FC = () => {
    const navigation = useNavigation();
    const isFocused = useIsFocused();

    const [username,setUserName] = useState("")
    const [password,setPassword] = useState("")
    const [savedUser, setSavedUser] = useState("")
    const [savedPass, setSavedPass] = useState("")
    const [accountStatus, setAccountStatus] = useState("Non-Active")

    const checkAccount = async () => {
        try{
            const value1 = await AsyncStorage.getItem('username')
            const value2 = await AsyncStorage.getItem('password')
            const value3 = await AsyncStorage.getItem('status')
            setSavedUser(value1)
            setSavedPass(value2)
            if(value3 !== null){setAccountStatus(value3)}
            console.log(value1+value2+value3)
        }catch (e) {
            console.log(e)
        }
    }

    useEffect(() =>{
        checkAccount();
    },[]);

    function validAccount(){
        if(username === savedUser && password === savedPass){
            setUserName("")
            setPassword("")
            navigation.navigate("dashboard")
        }else{
            setUserName("")
            setPassword("")
        }
    }

    function resetAccount(){
        const saveReset = async() =>{
            try{
                console.log("Reset")
                await AsyncStorage.setItem('status', "Non-Active" );
            }catch (e) {
                alert("Reset Failed")
            }
        }
        saveReset()
        checkReRender();
    }

    function checkReRender(){
        checkAccount()
    }

    return(
        <><StatusBar hidden />
            <View style={mainStyle.container}>
                {isFocused ? checkReRender() : console.log("Failed")}
                <Text style={mainStyle.basicTitle}>Personal</Text>
                <Text style={mainStyle.basicTitle}>Finance</Text>
                <Text style={mainStyle.basicTitle}>Simulator</Text>
                { accountStatus ==="Active" &&
                    <View>
                        <TextInput 
                            style={mainStyle.inputTextStyle}
                            placeholder="Username" 
                            onChangeText={text=>setUserName(text)}
                            value={username}
                            />
                        <TextInput 
                            style={mainStyle.inputTextStyle}
                            placeholder="password" 
                            onChangeText={text=>setPassword(text)}
                            value={password}/>
                        <Button title="Start" onPress={() => validAccount()}/>
                        <View style={{marginTop: 5}}>
                            <Button title="Reset" onPress={() => resetAccount()}/>
                        </View>
                    </View>
                }
                {accountStatus ==="Non-Active" &&
                    <View>
                        <Button title="Create Account" onPress={ () => navigation.navigate("create")}/>
                    </View>
                }
            </View>
        </>
    )
}

export default App;