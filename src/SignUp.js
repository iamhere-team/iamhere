import React, { Component } from 'react';
import { StyleSheet,Text,View,TextInput,Button,TouchableHighlight,Image,Alert,Modal } from 'react-native';
import { Auth } from 'aws-amplify';

export default class SignUp extends Component {

  constructor(props) {
    super(props);
    this.state = {
      fullName: '',
      email   : '',
      password: '',
      confirm_password: '',
      confirmation_code: '',
      modal_visible: false,
    };
  }

  onClickListener = (handlerId) => {
    //alert(JSON.stringify(this.state));
    if(handlerId === 'SignUp'){
      //   alert(JSON.stringify(this.state));
    const { email, password, confirm_password } = this.state;
    // Make sure passwords match
      if (password === confirm_password) {
        
        Auth.signUp({
          username: email,
          password,
          attributes: { email },
          })
          // On success, show Confirmation Code Modal
          .then(() => this.setState({ modal_visible: true }))
          // On failure, display error in console
          .catch(err => alert(err.code));
       } else {
            alert('Passwords do not match.');
        }
      //  alert(JSON.stringify(this.state));
    }
    else{
      const { email, confirmation_code } = this.state;
      Auth.confirmSignUp(email, confirmation_code, {})
        .then(() => {
          this.setState({ modal_visible: false });
          alert('Sign up is successful');
          this.props.navigation.navigate('Home')
        })
        .catch(err => alert(err.code));
    }

  }

  
  

  render() {
    return (
      <View style={styles.container}>
        <View style={styles.inputContainer}>
          <Image style={styles.inputIcon} source={{uri: 'https://png.icons8.com/male-user/ultraviolet/50/3498db'}}/>
          <TextInput style={styles.inputs}
              placeholder="Full name"
              keyboardType="email-address"
              underlineColorAndroid='transparent'
              onChangeText={(fullName) => this.setState({fullName:fullName})}/>
        </View>

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
        <View style={styles.inputContainer}>
          <Image style={styles.inputIcon} source={{uri: 'https://png.icons8.com/key-2/ultraviolet/50/3498db'}}/>
          <TextInput style={styles.inputs}
              placeholder="Confirm Password"
              secureTextEntry={true}
              underlineColorAndroid='transparent'
              onChangeText={(confirm_password) => this.setState({confirm_password:confirm_password})}/>
        </View>

        <TouchableHighlight style={[styles.buttonContainer, styles.signupButton]} onPress={() => this.onClickListener('SignUp')}>
          <Text style={styles.signUpText}>Sign up</Text>
        </TouchableHighlight>
        
        <Modal
          visible={this.state.modal_visible}
        >
          <View style={styles.container}>

            <View style={styles.inputContainer}>
            <Image style={styles.inputIcon} source={{uri: 'https://png.icons8.com/key-2/ultraviolet/50/3498db'}}/>
            <TextInput style={styles.inputs}
               placeholder="Confirmation Code"
               secureTextEntry={true}
               underlineColorAndroid='transparent'
               onChangeText={(confirmation_code) => this.setState({confirmation_code:confirmation_code})}/>
            </View>

            <TouchableHighlight style={[styles.buttonContainer, styles.signupButton]} onPress={() => this.onClickListener('Confirmation')}>
              <Text style={styles.signUpText}>Confirm</Text>
            </TouchableHighlight>

          </View>
        </Modal>
      </View>
    );
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
