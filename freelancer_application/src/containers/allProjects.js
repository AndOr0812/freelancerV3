import React,{Component} from 'react';
import {withRouter,Link} from 'react-router-dom';
import Header from '../components/headers';
import Home from './home';
import {connect} from "react-redux";
import {getUserProfile, getAllProjects,getProjectDetails} from "../actions";
import {reduxForm} from "redux-form";

class AllProjects extends Component{

    componentWillMount(){
        if (JSON.stringify(this.props.current_user) === "{}"){
            this.props.history.push('/login');
        }
    }

    componentDidMount(){
        if(this.props.current_user.emailid !== undefined || this.props.current_user.emailid !== null){
            this.props.getAllProjects((res)=>{
                console.log("Inside the profile view,The current user profile details fetched so far are :");
                console.log(JSON.stringify(res.projectdetails));
            });
        }
    }

    handleClick(project_id){
        console.log(`project Id is ${project_id}`);
        this.props.getProjectDetails(project_id,(results)=> {
            console.log(`results is ${results}`);
            /*let path = `/projectDetail/${project_id}`*/
            this.props.history.push(`/projectDetail/${project_id}`);
        })
    }
    openProjects = this.props.allOpenProjects.map(function(proj) {
        return (
            <tr key={proj.id} onClick={()=>this.handleClick(proj.id)}>
                <td>{proj.proj_name}</td>
                <td>{proj.proj_desc}</td>
                <td>{proj.proj_skills}</td>
                <td><Link to='profile/${proj.employer}' className="nav-link">{proj.employername}</Link></td>
                <td>{proj.proj_budget}</td>
            </tr>
        );}.bind(this));

    render(){
        return(
            <div>
                <Header/>
                <Home/>
                <h4>All Projects Page</h4>
                <table className="table table-hover">
                    <thead className="thead-dark">
                    <tr>
                        <th scope="col">Project Title</th>
                        <th scope="col">Project Description</th>
                        <th scope="col">Skills Required</th>
                        <th scope="col">Employer</th>
                        <th>Budget Range</th>
                    </tr>
                    </thead>
                    <tbody>
                    {this.props.current_user ? this.openProjects : (() => {
                        return(<tr></tr>);
                    })}
                    </tbody>
                </table>
            </div>
        );
    }
}

const mapStateToProps=(state)=>{
    return {
        current_user:state.userProfile,
        allOpenProjects: state.allOpenProjects
    }
};
export default withRouter(connect(mapStateToProps,{getUserProfile,getAllProjects,getProjectDetails})(AllProjects));

//export default withRouter(AllProjects);