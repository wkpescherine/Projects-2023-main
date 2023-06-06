import React , { FC , useEffect, useState} from "react";
import { View , Text, Button } from "react-native";
import { useIsFocused , useNavigation } from "@react-navigation/native";
import mainStyle from "../stylesheets/mainStyleSheet"
import { StatusBar } from "expo-status-bar";
import { Stocks , Bank , Occupation , CreditCards , DailyTasks, Profile } from "./components"
import AsyncStorage from "@react-native-async-storage/async-storage"

const App : FC = () => {
    const navigation = useNavigation();
    const isFocused = useIsFocused()

    const [name,setName] = useState("")
    const [score,setScore] = useState(0)
    const [wealth, setWealth] = useState("")
    const [cashOnHand, setCashOnHand] = useState("")

    const getData = async () => {
        try{
            const value1 = await AsyncStorage.getItem('username')
            const value2 = await AsyncStorage.getItem('wealth')
            const value3 = await AsyncStorage.getItem('cashOnHand')
            if( value1 !== null && value2 !== null && value3 !== null){
                setName(value1);
                setWealth(value2);
                setCashOnHand(value3)
            }else {
                alert("Value was null")
            }
        }catch (e) {
            console.log(e)
        }
    }

    useEffect(() =>{
        getData();
    },[]);

    const renderDashboard = () =>{
        getData()
    }

    return(
        <><StatusBar hidden />
            <View style={mainStyle.container}>
                {isFocused ? renderDashboard() : console.log("Left Dash")}
                <Text style={mainStyle.basicText}>Dashboard</Text>
                <Text style={mainStyle.basicText}>{name}</Text>
                <Text style={mainStyle.basicText}> Total Wealth: ${wealth}</Text>
                <Text style={mainStyle.basicText}> Cash On Hand: ${cashOnHand}</Text>
                <View style={mainStyle.spacer} />
                <CreditCards />
                <View style={mainStyle.spacer} />
                <Occupation />
                <View style={mainStyle.spacer} />
                <Bank />
                <View style={mainStyle.spacer} />
                <Stocks />
                <View style={mainStyle.spacer} />
                <DailyTasks />
                <View style={mainStyle.spacer} />
                <Profile />
                <View style={mainStyle.spacer} />
                <Text style={mainStyle.basicText}> {score} </Text>
                <View style={mainStyle.spacer} />
                <View style={mainStyle.horizonFlow}>
                    <View style={{padding: 5,}}>
                        <Button title="Logout" onPress={() => navigation.navigate("main")}/>
                    </View>
                    <Button title="Setting" onPress={() => navigation.navigate("settings")}/>
                </View>
            </View>
        </>
    )
}

export default App;