import React , { FC , useEffect, useState} from "react";
import { View , Text, Button } from "react-native";
import { useNavigation } from "@react-navigation/native";
import mainStyle from "../stylesheets/mainStyleSheet"
import { StatusBar } from "expo-status-bar";
import { Stocks , Bank , Occupation , CreditCards} from "./components"
import AsyncStorage from "@react-native-async-storage/async-storage"

const App : FC = () => {
    const navigation = useNavigation();

    const [name,setName] = useState("")
    const [score,setScore] = useState(0)
    const [wealth, setWealth] = useState("")

    const getData = async () => {
        try{
            const value1 = await AsyncStorage.getItem('username')
            const value2 = await AsyncStorage.getItem('wealth')
            if( value1 !== null){
                setName(value1);
                setWealth(value2);
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

    return(
        <><StatusBar hidden />
            <View style={mainStyle.container}>
                <Text style={mainStyle.basicText}>Dashboard</Text>
                <Text style={mainStyle.basicText}>{name}</Text>
                <Text style={mainStyle.basicText}>Wealth: {wealth}</Text>
                <View style={mainStyle.spacer} />
                <CreditCards />
                <View style={mainStyle.spacer} />
                <Occupation />
                <View style={mainStyle.spacer} />
                <Bank />
                <View style={mainStyle.spacer} />
                <Stocks />
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