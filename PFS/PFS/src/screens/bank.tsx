import React , { FC , useEffect , useState} from "react";
import { View , Text, Button , Image, TextInput} from "react-native";
import { useIsFocused , useNavigation } from "@react-navigation/native";
import mainStyle from "../stylesheets/mainStyleSheet"
import { StatusBar } from "expo-status-bar";
import AsyncStorage from "@react-native-async-storage/async-storage";

const App : FC = () => {
    const navigation = useNavigation();
    const isFocused = useIsFocused()
    
    const [cashOnHand,setCashOnHand] = useState("")
    const [chaseTotal, setChaseTotal] = useState("0")
    const [chaseAmount,setChaseAmount] = useState(0)
    const [boaTotal, setBoATotal] = useState("0")
    const [boaAmount,setBoAAmount] = useState(0)
    const [confirmChase,setConfirmChase] = useState("None")
    const [confirmBoA, setConfirmBoA] = useState("None")

    const getData = async() =>{
        try{
            const value1 = await AsyncStorage.getItem('cashOnHand')
            const value2 = await AsyncStorage.getItem('chaseAccount')
            const value3 = await AsyncStorage.getItem('boaAccount')
            setCashOnHand(value1)
            setChaseTotal(value2)
            setBoATotal(value3)
        }catch (e) {
            console.log(e)
        }
    }

    useEffect(()=>{
        getData()
    },[])

    const setConfirm = () => {
        setConfirmChase("None")
        setConfirmBoA("None")
    }

    const depositIntoAccount = (bank:string, amount:number) => {
        var cash = Number(cashOnHand)
        var cashDeposited = Number(amount)
        var tempCash = 0
        var tempDeposit = 0
        if(bank === ""){
            setConfirmChase("None")
            setConfirmBoA("None")
        }
        if(amount > cash){
            var cashHand = cash
            alert("The amount you have entered is greater then cash on hand")
            if(bank==="boa"){setBoAAmount(cashHand)}
            if(bank==="chase"){setChaseAmount(cashHand)}
        }else {
            if(bank ==="boa"){
                tempDeposit = Number(boaTotal)+cashDeposited
                tempCash = cash - amount
                setBoATotal(String(tempDeposit))
                setCashOnHand(String(tempCash))
                setBoAAmount(0)
                setConfirmBoA("Confirm")
            }
            if(bank ==="chase"){
                tempDeposit = Number(chaseTotal) + cashDeposited
                tempCash = cash - amount
                setChaseTotal(String(tempDeposit))
                setCashOnHand(String(tempCash))
                setChaseAmount(0)
                setConfirmChase("Confirm")
            }
            saveData()
        }
    }

    const withdrawFromAccount = (bank:string, amount:number) =>{
        var cash = Number(cashOnHand)
        var withdrawn = Number(amount)
        var tempCash = 0
        var tempAccount = 0
        if(bank === "chase"){
            if(withdrawn <= Number(chaseTotal) ){
                tempAccount = Number(chaseTotal) - withdrawn
                tempCash = cash + withdrawn
                setCashOnHand(String(tempCash))
                setChaseTotal(String(tempAccount))
                setChaseAmount(0)
                setConfirmChase("Confirm")
            }else{
                alert("The withdrawl amount is greater then amount in account")
                setChaseAmount(0)
            }
        }
        if(bank === "boa"){
            if(withdrawn <= Number(boaTotal)){
                tempAccount = Number(boaTotal) - withdrawn
                tempCash = cash + withdrawn
                setCashOnHand(String(tempCash))
                setBoATotal(String(tempAccount))
                setBoAAmount(0)
                setConfirmBoA("Confirm")
            }else{
                alert("The withdrawl amount is greater then amount in account")
                setBoAAmount(0)
            }
        }
        saveData()
    }


    const saveData = async() =>{
        try{
            await AsyncStorage.setItem('cashOnHand', cashOnHand );
            await AsyncStorage.setItem('chaseAccount', chaseTotal );
            await AsyncStorage.setItem('boaAccount', boaTotal );
            console.log("Saved Area")
            {isFocused ? console.log("Render Save") : console.log("Left Bank")}
        }catch (e) {
            alert("Failed")
        }
    }

    function checkReRender(){
        console.log("checked")
    }

    return(
        <><StatusBar hidden />
            <View style={mainStyle.container}>
                {isFocused ? checkReRender() : console.log("Left Bank")}
                <Text style={mainStyle.basicCatTitle}>Banking</Text>
                <Text style={mainStyle.basicText}>${cashOnHand}</Text>
                <View style={mainStyle.spacer} />
                <View style={mainStyle.horizonFlow}>
                    <Image source={require("../images/chasebank.png")} style={{width: 120, height: 120}} />
                    <View>
                        <View style={mainStyle.horizonFlow}>
                            <Text style={mainStyle.basicText}> Chase </Text>
                            <Text style={mainStyle.basicText}> ${chaseTotal}</Text>
                        </View>
                        <View>
                           <TextInput                             
                                style={mainStyle.inputTextStyle}
                                onChangeText={text=>setChaseAmount(text)}
                                maxLength={6}
                                value={chaseAmount}
                                keyboardType= {"number-pad"}
                            ></TextInput>
                        </View>
                        <View>
                            {confirmChase ==="None" &&
                                <View style={mainStyle.horizonFlow}>
                                    <Button title="Withdrawal" onPress={() => withdrawFromAccount("chase", chaseAmount)}/>
                                    <View style={{padding:5}}></View>
                                    <Button title="Deposit" onPress={()=>depositIntoAccount ("chase", chaseAmount)}/>
                                </View>
                            }
                            {confirmChase ==="Confirm" &&
                                <View style={mainStyle.horizonFlow}>
                                    <View style={{width: "56%"}}>
                                        <Button title="confirm" onPress={()=> depositIntoAccount("", 0)}/>
                                    </View>
                                </View>
                            }
                        </View>
                    </View>
                </View>
                <View style={mainStyle.spacer} />
                <View style={mainStyle.horizonFlow}>
                    <Image source={require("../images/bankofAmerica.png")} style={{width: 120, height: 120}} />
                    <View>
                        <View style={mainStyle.horizonFlow}>
                            <Text style={mainStyle.basicText}> Bank of America</Text>
                            <Text style={mainStyle.basicText}> ${boaTotal}</Text>
                        </View>
                        <View>
                           <TextInput                             
                                style={mainStyle.inputTextStyle}
                                onChangeText={text=>setBoAAmount(text)}
                                maxLength={6}
                                value={boaAmount}
                                keyboardType= {"number-pad"}
                            ></TextInput>
                        </View>
                        <View>
                            {confirmBoA ==="None" &&
                                <View style={mainStyle.horizonFlow}>
                                    <Button title="Withdrawal" onPress={()=> withdrawFromAccount("boa", boaAmount)}/>
                                    <View style={{padding:5}}></View>
                                    <Button title="Deposit" onPress={()=>   depositIntoAccount    ("boa", boaAmount)}/>
                                </View>
                            }
                            {confirmBoA ==="Confirm" &&
                                <View style={mainStyle.horizonFlow}>
                                    <View style={{width: "56%"}}>
                                        <Button title="confirm" onPress={()=>depositIntoAccount("",0)}/>
                                    </View>
                                </View>
                            }
                        </View>
                    </View>
                </View>
                <View style={mainStyle.spacer} />
                <Button title="Back to Dashboard" onPress={() => navigation.navigate("dashboard")}/>
            </View>
        </>
    )
}

export default App;