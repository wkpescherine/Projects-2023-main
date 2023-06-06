import React , { FC , useEffect , useState} from "react";
import { View , Text, Button } from "react-native";
import { useNavigation } from "@react-navigation/native";
import mainStyle from "../../stylesheets/mainStyleSheet"
import { StatusBar } from "expo-status-bar";
import AsyncStorage from "@react-native-async-storage/async-storage"

const App : FC = () => {
    const navigation = useNavigation();

    const [job,setJob] = useState("")

    const getData = async () => {
        try{
            const value = await AsyncStorage.getItem('employment')
            if( value !== null){
                setJob(value);
            }else {
                console.log("Value was null")
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
            <View style={mainStyle.horizonFlow}>
                <Text style={mainStyle.basicText}>Occupation: {job}</Text>
                <Button title=">" onPress={() => navigation.navigate("occupation")}/>
            </View>
        </>
    )
}

export default App;