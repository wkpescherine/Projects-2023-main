import React , { FC, useState } from "react";
import { View , Text , Button , TextInput, StyleSheet} from "react-native";
import { useNavigation } from "@react-navigation/native";
//import styles from "../Stylesheets/containers"
import containers from "../Stylesheets/containers";
import texts from "../Stylesheets/texts"
import States1 from "../components/states1"
import States2 from "../components/states2"
import States3 from "../components/states3"
import States4 from "../components/states4"
import States5 from "../components/states5"
import States6 from "../components/states6"
import States7 from "../components/states7"
import Doctors1 from "../components/doctors1"

const App : FC = () => {
    const navigation = useNavigation();
    const [client,setClient] = useState("Patient");
    const [rate,setRate] = useState("Slow");
    const [cost, setCost] = useState(0);
    const [age, setAge] = useState(0);

    function handleClient(){
        if(client==="Patient"){
            setClient("Medical")
        }else{
            setClient("Patient")
        }
    }

    function handleRate(){
        if(rate === "Slow"){
            setRate("Normal")
        }else if (rate === "Normal"){
            setRate("Increased")
        }else if (rate === "Increased"){
            setRate("Rapid")
        }else{
            setRate("Slow")
        }
    }

    function handleAge(sign){
        if(sign === "+"){
            let tempValue = age+1;
            setAge(tempValue)
        }else if( sign ==="-" && age>0){
            let TempValueSub = age-1;
            setAge(TempValueSub)
        }
    }

    return(
        <View style={containers.container}>
            {/* Client medical picker*/}
            <View style={containers.container90}>
                <Button onPress={()=>handleClient()} title={client} />    
            </View>
            {/* User naming section */}
            <View style={containers.horizonFlow}>
                <View style={containers.container30}>
                    <Text style={texts.basicText}>Username:</Text>
                </View>
                <TextInput style={containers.inputContainer} placeholder="Enter username" />
            </View>
            {/* User email section */}
            <View style={containers.horizonFlow}>
                <View style={containers.container30}>
                    <Text style={texts.basicText}>Email:</Text>
                </View>
                <TextInput style={containers.inputContainer} placeholder="Enter Email"/>
            </View>
            {/* User password section */}
            <View style={containers.horizonFlow}>
                <View style={containers.container30}>
                    <Text style={texts.basicText}>Password:</Text>
                </View>
                <TextInput style={containers.inputContainer} placeholder="Enter password" />
            </View>
            {/* List fo states section */}
            <States1 />
            <States2 />
            <States3 />
            <States4 />
            <States5 />
            <States6 />
            <States7 />
            {/* List of medical doctors supported or setting up*/}
            <Doctors1 />
            {/* Age and rate of growth section */}
            <View style={containers.horizonFlow}>
                <Text style={texts.basicText}>Age:</Text>
                <Text style={texts.basicText}>{age}</Text>
                <Button title="+" onPress={()=>handleAge("+")}/>
                <Text style={containers.spacing} />
                <Button title="-" onPress={()=>handleAge("-")}/>
                <Text style={texts.basicText}>Rate : </Text>
                <Button title={rate} onPress={()=>handleRate()} />
            </View>
            {/* Cost section */}
            <View>
                <Text style={texts.basicText}>Cost: ${cost}</Text>
            </View>
            {/* Action buttons */}
            <View style={containers.container90}>
                <Button title="Create Account" onPress={()=>navigation.navigate("home")}/>
            </View>
            <View style={containers.container90}>
                <Button title="Back" onPress={()=>navigation.navigate("main")}/>
            </View>
        </View>
    )
}

export default App;