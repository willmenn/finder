import React, {Component} from 'react';
import './App.css';
import SimpleMap from "./SingleMap";
import axios from 'axios';

class App extends Component {
    constructor() {
        super()
        this.state = {
            lat: "",
            long: "",
            coordinates: [],
            zoom: 11
        }
        this.latChange = this.handleLatChange.bind(this);
        this.longChange = this.handleLongChange.bind(this);
        this.submitAction = this.handleSubmit.bind(this);
        this.geoLocation = this.getLocation.bind(this);
        this.getPosition = this.showPosition.bind(this);
    }

    componentDidMount(){
        this.geoLocation.call()
    }

    handleLatChange(event) {
        this.setState({lat: event.target.value});
    }

    handleLongChange(event) {
        this.setState({long: event.target.value});
    }

    handleSubmit(event) {
        event.preventDefault();
        this.getClosestStores();
        return false;
    }


    getClosestStores() {
        axios.get('/stores/nearby', {
            params: {
                latitude: this.state.lat,
                longitude: this.state.long
            }
        }).then(response => {
            this.setState({coordinates: response.data})
        })
    }

    getLocation() {
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(this.getPosition);
        }
    }

    showPosition(position) {

        this.setState({lat: position.coords.latitude});
        this.setState({long: position.coords.longitude});
        this.getClosestStores();
    }

    render() {
        return (
            <div className="App">
                <form onSubmit={this.submitAction}>
                    <h4>Latitude:</h4>
                    <input type='number' value={this.state.lat} onChange={this.latChange}/>
                    <h4>Longitude:</h4>
                    <input type='number' value={this.state.long} onChange={this.longChange}/>
                    <button type='submit' style={{display: 'block', margin: 'auto'}}>
                        Find closest stores
                    </button>
                </form>
                <SimpleMap center={this.getCenterOrDefault()} zoom={this.state.zoom}
                           coordinates={this.state.coordinates}/>
            </div>
        );
    }

    getCenterOrDefault() {
        return {
            lat: this.state.lat === "" ? 52.1 : parseFloat(this.state.lat),
            lng: this.state.long === "" ? 4.8 : parseFloat(this.state.long)
        };
    }
}

export default App;
