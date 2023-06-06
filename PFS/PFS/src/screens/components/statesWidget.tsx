import React , { FC , useState} from "react";
import { View , Text, Button } from "react-native";
import { useNavigation } from "@react-navigation/native";
import mainStyle from "../../stylesheets/mainStyleSheet"
import { StatusBar } from "expo-status-bar";
import AsyncStorage from "@react-native-async-storage/async-storage"

const App : FC = () => {
    const navigation = useNavigation();

    const [state, setState] = useState("");
    const [locationValue , setLocationValue] = useState(0);

    const statesUSA = ["AK","AL","AZ","CO","CT","DE","FL","GA","HI","KA","KY","LA","MO","MN","NE","NJ","NM","NY","OK","OR","PA","RI","SC","SD","TN","TX","UT","VA","VT","WA",];

    const saveStateData = async() =>{
        try{
            await AsyncStorage.setItem('state', state);
        }catch (e) {
            alert("Failed")
        }
    }

    const nextState = () => {
        if(locationValue < 29){
            setLocationValue(locationValue+1)
            setState(statesUSA[locationValue])
            saveStateData()
        }
    }

    const prevState = () => {
        if(locationValue >0){
            setLocationValue(locationValue-1)
            setState(statesUSA[locationValue])
            saveStateData()
        }
    }

    return(
        <><StatusBar hidden />
            <View style={mainStyle.horizonFlow}>
                <Button title="<" onPress={() => prevState()}/>
                <Text style={mainStyle.basicText}>{state}</Text>
                <Button title=">" onPress={() => nextState()}/>
            </View>
        </>
    )
}

export default App;