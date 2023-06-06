import { StyleSheet } from "react-native";

export default StyleSheet.create({
    basicTitle:{
        fontSize: 48,
        color: "#ffffff",//white
    },
    basicText:{
        color:"#ffffff",//white
        padding: 5,
    },
    container:{
        flex: 1,
        justifyContent: "center",
        alignItems: "center",
        backgroundColor: "#000000",//This gets me black
    },
    spacer:{
        backgroundColor: "#ffffff",
        width: "100%",
        height: 1,
        margin: 15,
    },
    horizonFlow:{
        padding: 5,
        flexDirection: "row",
        justifyContent: "center",
        alignItems: "center",
    },
    inputTextStyle:{
        width: 150,
        justifyContent: "center",
        textAlign:"center",
        margin: 5,
        backgroundColor: "#ffffff",
    }
})