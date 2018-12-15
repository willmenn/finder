import React, { Component } from 'react';
import GoogleMapReact from 'google-map-react';

const StoreComponent = ({ text }) => <div style={{color: 'red'}}>{text}</div>;

class SimpleMap extends Component {
    constructor(props) {
        super(props);
    }


    render() {
        return (
            // Important! Always set the container height explicitly
            <div style={{ margin: 'auto',height: '600px', width: '800px' }}>
                <GoogleMapReact
                    bootstrapURLKeys={{ key: "AIzaSyBxgh4JjVSbr7bSW6D9eKsSeYeiYflMuIg"}}
                    defaultCenter={this.props.center}
                    defaultZoom={this.props.zoom}
                >
                    {this.props.coordinates.map( c =>{
                        return <StoreComponent
                            lat={c.latitude}
                            lng={c.longitude}
                            text={c.addressName}
                        />
                    })}
                </GoogleMapReact>
            </div>
        );
    }
}

export default SimpleMap;