import React , { FC , useState , useEffect} from "react";
import { View , Text, Button } from "react-native";
import { useNavigation } from "@react-navigation/native";
import mainStyle from "../stylesheets/mainStyleSheet"
import { StatusBar } from "expo-status-bar";
import AsyncStorage from "@react-native-async-storage/async-storage";

const App : FC = () => {
    const navigation = useNavigation()

    //Info related to Apple Stock
    const [appleStockQty, setAppleStockQty] = useState(0)
    const [appleOpen, setAppleOpen] = useState(34)
    const [appleClose, setAppleClose] = useState(37)
    //Info related to Google Stock
    const [googleStockQty, setGoogleStockQty] = useState(0)
    const [googleOpen, setGoogleOpen] = useState(38)
    const [googleClose, setGoogleClose] = useState(45)
    //Info related to Tesla Stock
    const [teslaStockQty, setTeslaStockQty] = useState(0)
    const [teslaOpen, setTeslaOpen] = useState(22)
    const [teslaClose, setTeslaClose] = useState(21)

    //Info related to Money 
    const [chaseCash,setChaseCash] = useState(0)
    const [boaCash,setBoaCash] = useState(0)

    //Info related to the Portfolio Worth
    const [invest, setInvest] = useState(0)
    const [worth, setWorth] = useState(0)

    function stockOptions(purchase:string, action:string, cash:number){
        let tempInvest = invest
        let tempWorth = worth
        if(purchase === "Apple"){
            if(action === "Buy"){
                let temp = appleStockQty+1
                setAppleStockQty(temp)
            }else{
                let temp = appleStockQty-1
                setAppleStockQty(temp)
            }
        }
        if(purchase === "Google"){
            if(action === "Buy"){
                let temp = googleStockQty+1
                setGoogleStockQty(temp)
            }else{
                let temp = googleStockQty-1
                setGoogleStockQty(temp)
            }
        }
        if(purchase === "Tesla"){
            if(action === "Buy"){
                let temp = teslaStockQty+1
                setTeslaStockQty(temp)
            }else{
                let temp = teslaStockQty-1
                setTeslaStockQty(temp)
            }
        }
        if(action === "Buy"){
            if(chaseCash >= cash){
                const tempCash = chaseCash-cash
                setChaseCash(tempCash)
            }else if(boaCash >= cash){
                const tempCash = boaCash-cash
                setChaseCash(tempCash)
            }else{
                alert("No money in bank to purchase")
            }
            tempInvest += cash
        } else{
            if(chaseCash > boaCash){
                const tempCash = chaseCash+cash
                setChaseCash(tempCash)
            }else{
                const tempCash = boaCash+cash
                setBoaCash(tempCash)
            }
            tempInvest -= cash
        }
        tempWorth = (appleStockQty*appleClose)+(googleStockQty*googleClose)+(teslaStockQty*teslaClose) 
        setInvest(tempInvest)
        setWorth(tempWorth)
    }

    const getData = async() =>{
        try{
            const value1 = await AsyncStorage.getItem('chaseAccount')
            const value2 = await AsyncStorage.getItem('boaAccount')
            setChaseCash(Number(value1))
            setBoaCash(Number(value2))
        }catch (e) {
            console.log(e)
        }
    }

    useEffect(()=>{
        getData()
    },[])

    const saveData = async() => {

    }

    return(
        <><StatusBar hidden />
            <View style={mainStyle.container}>
                <Text style={mainStyle.basicCatTitle}>Stock Market Section</Text>
                <View style={mainStyle.horizonFlow}>
                    <Text style={mainStyle.basicText}>Chase: ${chaseCash}</Text>
                    <Text style={mainStyle.basicText}>BoA: ${boaCash}</Text>
                </View>
                <View style={mainStyle.spacer} />
                <View style={mainStyle.horizonFlow}>
                    <Text style={mainStyle.basicText}> Apple</Text>
                    <Text style={mainStyle.basicText}> Open: ${appleOpen}</Text>
                    <Text style={mainStyle.basicText}> Closed: ${appleClose}</Text>
                    <Text style={mainStyle.basicText}> Chng: +1%</Text>
                    <Button title="BUY" onPress={() => stockOptions("Apple", "Buy", appleClose)}/>
                </View>
                <View style={mainStyle.horizonFlow}>
                    <Text style={mainStyle.basicText}> Google</Text>
                    <Text style={mainStyle.basicText}> Open: ${googleOpen}</Text>
                    <Text style={mainStyle.basicText}> Closed: ${googleClose}</Text>
                    <Text style={mainStyle.basicText}> Chng: +1.4%</Text>
                    <Button title="BUY" onPress={() => stockOptions("Google", "Buy", googleClose)}/>
                </View>
                <View style={mainStyle.horizonFlow}>
                    <Text style={mainStyle.basicText}> Tesla</Text>
                    <Text style={mainStyle.basicText}> Open: ${teslaOpen}</Text>
                    <Text style={mainStyle.basicText}> Closed: ${teslaClose}</Text>
                    <Text style={mainStyle.basicText}> Chng: -1%</Text>
                    <Button title="BUY" onPress={() => stockOptions("Tesla", "Buy", teslaClose)}/>
                </View>
                <View style={mainStyle.spacer} />
                <Text style={mainStyle.basicText}>Stock Portfolio</Text>
                <View style={mainStyle.horizonFlow}>
                    <Text style={mainStyle.basicText}>Invested: ${invest}</Text>
                    <Text style={mainStyle.basicText}>Worth: ${worth}</Text>
                </View>
                <View>
                    {appleStockQty !== 0 &&
                        <View style={mainStyle.horizonFlow}>
                            <Text style={mainStyle.basicText}>Apple : {appleStockQty}</Text>
                            <Button title="SELL" onPress={() => stockOptions("Apple","Sell", appleClose)}/>
                        </View>
                    } 
                    {googleStockQty !== 0 &&
                        <View style={mainStyle.horizonFlow}>
                            <Text style={mainStyle.basicText}>Google : {googleStockQty}</Text>
                            <Button title="SELL" onPress={() => stockOptions("Google","Sell", googleClose)}/>
                        </View>
                    } 
                    {teslaStockQty !== 0 &&
                        <View style={mainStyle.horizonFlow}>
                            <Text style={mainStyle.basicText}>Tesla : {teslaStockQty}</Text>
                            <Button title="SELL" onPress={() => stockOptions("Tesla","Sell", teslaClose)}/>
                        </View>
                    }   
                </View>
                <View style={mainStyle.spacer} />
                <Button title="Back to Dashboard" onPress={() => {console.log("test this") ; navigation.navigate("dashboard")}}/>
            </View>
        </>
    )
}

export default App;