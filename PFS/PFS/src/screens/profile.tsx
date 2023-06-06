import React , { FC , useState , useEffect } from "react";
import { View , Text, Button } from "react-native";
import { useNavigation } from "@react-navigation/native";
import mainStyle from "../stylesheets/mainStyleSheet"
import { StatusBar } from "expo-status-bar";
import AsyncStorage from "@react-native-async-storage/async-storage";

const App : FC = () => {
    const navigation = useNavigation(); 
    const [profileUsername,setProfileUsername] = useState("")
    const [profileActualWealth,setProfileActualWealth] = useState("0")
    const [profileBank,setProfileBank] = useState("0")
    const [profileOnHand,setProfileOnHand] = useState("0")
    const [profileDebt,setProfileDebt] = useState("0")
    const [profileStock,setProfileStock] = useState("0")

    const getData = async() =>{
        try{
            const value1 = await AsyncStorage.getItem('username')
            const value2 = await AsyncStorage.getItem('wealth')
            const value3 = await AsyncStorage.getItem('cashOnHand')
            const value4 = await AsyncStorage.getItem('chaseAccount')
            const value5 = await AsyncStorage.getItem('boaAccount')
            var bankTotal = Number(value4) + Number(value5)
            setProfileUsername(value1)
            setProfileActualWealth(value2)
            setProfileOnHand(value3)
            setProfileBank(String(bankTotal))
        }catch (e) {
            console.log(e)
        }
    }

    useEffect(()=>{
        getData()
    },[])

    return(
        <><StatusBar hidden />
            <View style={mainStyle.container}>
                <Text style={mainStyle.basicText}>Occupation Section</Text>
                <Text style={mainStyle.basicText}>Username:{profileUsername}</Text>
                <Text style={mainStyle.basicText}>Total Cash onHand: {profileOnHand}</Text>
                <Text style={mainStyle.basicText}>Total Bank Value: {profileBank}</Text>
                <Text style={mainStyle.basicText}>Total Stocks Value: {profileStock}</Text>
                <Text style={mainStyle.basicText}>Total Debt: {profileDebt}</Text>
                <Text style={mainStyle.basicText}>Actual Wealth:{profileActualWealth}</Text>
                <Button title="Back to Dashboard" onPress={() => navigation.navigate("dashboard")}/>
            </View>
        </>
    )
}

export default App;