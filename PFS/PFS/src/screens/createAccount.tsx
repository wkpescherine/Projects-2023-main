import React , { FC, useState } from "react";
import { View , Text, Button, TextInput } from "react-native";
import { useNavigation } from "@react-navigation/native";
import mainStyle from "../stylesheets/mainStyleSheet"
import { StatusBar } from "expo-status-bar";
import AsyncStorage from "@react-native-async-storage/async-storage"
import { States } from "./components"

const App : FC = () => {
    const navigation = useNavigation();

    //LOCAL STATE
    //Log in and account related information
    const [newUserName, setNewUserName] = useState("")
    const [newPassword, setNewPassword] = useState("")
    const [confirmUsername, setConfirmUserName] = useState("")
    const [confirmPassworc, setConfirmPassword] = useState("")

    //LOCAL STORAGE/STATE
    //Game Data will be here actually
    const [timeRate,setTimeRate] = useState("24")
    const [wealth, setWealth] = useState("100")
    const [educationLevel, setEducationLevel] = useState("HS Dropout")
    const [employment, SetEmployment] = useState("Unemployed")
    //const [cashOnHand,setCashOnHand] = useState("100")

    const setRateOfTime = () => {
        if(timeRate === "24"){setTimeRate("12")}
        else if (timeRate === "12"){setTimeRate("6")}
        else if (timeRate === "6"){setTimeRate("4")}
        else if (timeRate === "4"){setTimeRate("2")}
        else if (timeRate === "2"){setTimeRate("24")}
    }

    const setEducation = () => {
        if(educationLevel === "HS Dropout"){setEducationLevel("GED"); setWealth("500")}
        else if (educationLevel === "GED"){setEducationLevel("HS Grad"); setWealth("500")}
        else if (educationLevel === "HS Grad"){setEducationLevel("PT College");setWealth("1500")}
        else if (educationLevel === "PT College"){setEducationLevel("FT College");setWealth("1500")}
        else if (educationLevel === "FT College"){setEducationLevel("2yr Grad");setWealth("3000")}
        else if (educationLevel === "2yr Grad"){setEducationLevel("4yr Grad");setWealth("3000")}
        else if (educationLevel === "4yr Grad"){setEducationLevel("Masters"); setWealth("7500")}
        else if (educationLevel === "Masters"){setEducationLevel("PhD"); setWealth("7500")}
        else if (educationLevel === "PhD"){setEducationLevel("HS Dropout"); setWealth("100")}
    }

    const saveData = async() =>{
        try{
            //Dashboard and account related data
            await AsyncStorage.setItem('username', newUserName);
            await AsyncStorage.setItem('password', newPassword);
            await AsyncStorage.setItem('wealth', wealth );
            await AsyncStorage.setItem('status', "Active" );
            await AsyncStorage.setItem('timeRate', timeRate );
            await AsyncStorage.setItem('employment', employment );
            await AsyncStorage.setItem('cashOnHand', wealth );
            //Bank saved data
            await AsyncStorage.setItem('chaseAccount', "0" );
            await AsyncStorage.setItem('boaAccount', "0" );
            //Credit card saved data
            await AsyncStorage.setItem('ficotScore', "600" );
            await AsyncStorage.setItem('visaStatus', "Apply" );
            await AsyncStorage.setItem('mastercardStatus', "Apply" );
            await AsyncStorage.setItem('amexStatus', "Apply" );
            await AsyncStorage.setItem('visaLimit', "" );
            await AsyncStorage.setItem('visaBalance', "" );
            await AsyncStorage.setItem('mastercardLimit', "" );
            await AsyncStorage.setItem('mastercardBalance', "" );
            await AsyncStorage.setItem('amexLimit', "" );
            await AsyncStorage.setItem('amexBalance', "" );            
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
                    <View style={mainStyle.horizonFlow}>
                        <Text style={mainStyle.basicText}>Username:</Text>
                        <TextInput 
                            style={mainStyle.inputTextStyle}
                            placeholder="Enter new username" 
                            onChangeText={text=>setNewUserName(text)}
                            value={newUserName}
                            />
                    </View>
                    <View style={mainStyle.horizonFlow}>
                        <Text style={mainStyle.basicText}>Password:</Text>
                        <TextInput 
                            style={mainStyle.inputTextStyle}
                            placeholder="Enter new password" 
                            onChangeText={text=>setNewPassword(text)}
                            value={newPassword}/>
                    </View>
                    <View style={mainStyle.horizonFlow}>
                        <Text style={mainStyle.basicText}>Username: </Text>
                        <TextInput 
                            style={mainStyle.inputTextStyle}                            
                            placeholder="Confirm new username" 
                            onChangeText={text=>setConfirmUserName(text)}
                            value={confirmUsername}
                            />
                    </View>
                    <View style={mainStyle.horizonFlow}>
                        <Text style={mainStyle.basicText}>Password:</Text>                    
                        <TextInput 
                            style={mainStyle.inputTextStyle}
                            placeholder="Confirm new password" 
                            onChangeText={text=>setConfirmPassword(text)}
                            value={confirmPassworc}/>
                    </View>
                    <View style={mainStyle.horizonFlow}>
                        <Button title="Time Rate : " onPress={() => setRateOfTime()}/>
                        <Text style={mainStyle.basicText}>{timeRate}</Text>
                    </View>
                    <View style={mainStyle.horizonFlow}>
                        <Button title="Education : " onPress={() => setEducation()}/>
                        <Text style={mainStyle.basicText}>{educationLevel}</Text>
                    </View>
                    <View style={mainStyle.horizonFlow}>
                        <Text style={mainStyle.basicText}>Initial Wealth: ${wealth}</Text>
                    </View>
                </View>
                <States />
                {newUserName === confirmUsername &&
                newPassword === confirmPassworc &&
                newPassword !== "" &&
                    <Button title="Create Account" onPress={() => saveData()}/>
                }
                <View style={{marginTop: 5}}>
                    <Button title="Back to Main" onPress={() => navigation.navigate("main")}/>
                </View>
            </View>
        </>
    )
}

export default App;