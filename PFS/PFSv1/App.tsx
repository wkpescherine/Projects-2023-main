import React from 'react';
import { NavigationContainer } from '@react-navigation/native';
import AppStack from "./src/navigator/appNavigator"
//import { Provider } from 'react-redux';
//import { StyleSheet, Text, View } from 'react-native';

export default function App() {
  return (
    <NavigationContainer>
      <AppStack />
    </NavigationContainer>
  );
}