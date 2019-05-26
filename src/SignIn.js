import React, { Component } from 'react';
import { StyleSheet,Text,View,TextInput,Button,TouchableHighlight,Image,Alert } from 'react-native';
import { Auth } from 'aws-amplify';

export default class SignIn extends Component {

    constructor(props) {
        super(props);
        this.state = {
          email   : '',
          password: '',
        }
      }
      onClickListener = (handler) => {    //will be filled after database is created
        const { email, password } = this.state;
       // alert(JSON.stringify(this.state));
        Auth.signIn(email, password)
        // If we are successful, navigate to Home screen
          .then( () => {
            alert('Sign in is successful');
            this.props.navigation.navigate('Home')
          })
        // On failure, display error in console
        .catch(err => alert(err.code));
      }
      
    render() {
        return (
          <View style={styles.container}>
            <View style={styles.inputContainer}>
              <Image style={styles.inputIcon} source={{uri: 'https://png.icons8.com/message/ultraviolet/50/3498db'}}/>
              <TextInput style={styles.inputs}
                  placeholder="Email"
                  keyboardType="email-address"
                  underlineColorAndroid='transparent'
                  onChangeText={(email) => this.setState({email:email})}/>
            </View>
            
            <View style={styles.inputContainer}>
              <Image style={styles.inputIcon} source={{uri: 'https://png.icons8.com/key-2/ultraviolet/50/3498db'}}/>
              <TextInput style={styles.inputs}
                  placeholder="Password"
                  secureTextEntry={true}
                  underlineColorAndroid='transparent'
                  onChangeText={(password) => this.setState({password:password})}/>
            </View>
    
            <TouchableHighlight style={[styles.buttonContainer, styles.signupButton]} onPress={() => this.onClickListener('SignIn')}>
              <Text style={styles.signUpText}>Sign in</Text>
            </TouchableHighlight>
          </View>
            )
    }
}

const styles = StyleSheet.create({

    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#00b5ec',
      },
      inputContainer: {
          borderBottomColor: '#F5FCFF',
          backgroundColor: '#FFFFFF',
          borderRadius:30,
          borderBottomWidth: 1,
          width:250,
          height:45,
          marginBottom:20,
          flexDirection: 'row',
          alignItems:'center'
      },
      inputs:{
          height:45,
          marginLeft:16,
          borderBottomColor: '#FFFFFF',
          flex:1,
      },
      inputIcon:{
        width:30,
        height:30,
        marginLeft:15,
        justifyContent: 'center'
      },
      buttonContainer: {
        height:45,
        flexDirection: 'row',
        justifyContent: 'center',
        alignItems: 'center',
        marginBottom:20,
        width:250,
        borderRadius:30,
      },
      signupButton: {
        backgroundColor: "#FF4DFF",
      },
      signUpText: {
        color: 'white',
      }

});