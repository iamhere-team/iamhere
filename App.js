import React from 'react';
import { Button, View, Text } from 'react-native';
import { createStackNavigator, createAppContainer } from 'react-navigation'; // Version can be specified in package.json
import { StyleSheet,TextInput,TouchableHighlight,Image,Alert } from 'react-native';
import SignUp from './src/SignUp.js';
import SignIn from './src/SignIn.js';

import Amplify from 'aws-amplify';
import aws_exports from './aws-exports';

Amplify.configure(aws_exports);

class HomeScreen extends React.Component {
  render() {
    return (
      <View style={styles.container}>
      
      
        <View style={styles.button1}>
        <Button 
          title="Sign Up"
          onPress={() => this.props.navigation.navigate('SignUp')}
        />
        </View>
        
        <View style={styles.button2}>
        <Button
          title="Sign In"  
          onPress={() => this.props.navigation.navigate('SignIn')}
        />
        </View>
      </View>
    );
  }
}

const RootStack = createStackNavigator(
  {
    Home: HomeScreen,
    SignUp: SignUp,
    SignIn: SignIn
  },
  {
    initialRouteName: 'Home',
  }
);

const AppContainer = createAppContainer(RootStack);

export default class App extends React.Component {
 
  render() {
    return <AppContainer />;
  }
}

const styles = StyleSheet.create({

  container: {
      flex: 1,
      justifyContent: 'center',
      alignItems: 'center',
      backgroundColor: '#FFFFFF',
    },
    button1: {
      position:"absolute",
        width:250,
        height:45,
        marginBottom:20,
        flexDirection: 'row',
        left:130,
        top:550,
        alignItems:'center'
    },
    button2: {
      position:"absolute",
      width:250,
      height:45,
      marginBottom:20,
      flexDirection: 'row',
      right:-50,
      top:550,
      alignItems:'center'
  }
    

});

