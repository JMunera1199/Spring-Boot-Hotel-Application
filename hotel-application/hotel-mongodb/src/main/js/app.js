'use strict';

// tag::vars[]
const React = require('react'); // <1>
const ReactDOM = require('react-dom'); // <2>
const client = require('./client'); // <3>
// end::vars[]

// tag::app[]
class App extends React.Component { // <1>

	constructor(props) {
		super(props);
		this.state = {guests: []};
	}

	componentDidMount() { // <2>
		client({method: 'GET', path: '/api/guest/guests'}).done(response => {
			this.setState({guests: response.entity});
		});
	}

	render() { // <3>
	    console.log("GUESTS2: " + this.state.guests);
		return (
			<GuestList guests={this.state.guests}/>
		)
	}
}
// end::app[]

// tag::guest-list[]
class GuestList extends React.Component{
	render() {
		console.log("HELP6:" + this.props);
		const guests = this.props.guests.map(guest =>
			<Guest key={guest} guest={guest}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
					</tr>
					{guests}
				</tbody>
			</table>
		)
	}
}
// end::guest-list[]

// tag::guest[]
class Guest extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.guest.firstName}</td>
				<td>{this.props.guest.lastName}</td>
			</tr>
		)
	}
}
// end::guest[]

// tag::render[]
ReactDOM.render(
	<App />,
	document.getElementById('react')
)
// end::render[]
