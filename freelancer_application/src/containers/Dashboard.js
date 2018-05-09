import React,{Component} from 'react';
import {withRouter,Link} from 'react-router-dom';
import {connect} from "react-redux";
import {getProjectDetails, getUserProfile,getMyBids} from "../actions";
import Header from '../components/headers';
import Home from './home';

class Dashboard extends Component{

    componentWillMount(){
        if (JSON.stringify(this.props.current_user) === "{}"){
            this.props.history.push('/login');
        }else if(JSON.stringify(this.props.myBids) === "[]"){
            this.props.history.push('/dashboard');
        }
    }

    render(){
        return(
            <div>
                <Header/>
                <Home/>
                <h4>Dashboard Page</h4>
            </div>
        );
    }
}

const mapStateToProps=(state)=>{
    return {
        current_user:state.userProfile,
        allOpenProjects: state.allOpenProjects,
        myBids: state.myBids
    }
};

export default withRouter(connect(mapStateToProps,{getProjectDetails, getUserProfile,getMyBids})(Dashboard));
//export default withRouter(Dashboard);