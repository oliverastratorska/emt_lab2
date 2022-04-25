import React from 'react';
import {useHistory} from 'react-router-dom'


const BooksEdit = (props) => {

    const history = useHistory();
    const [formData, updateFormData] = React.useState({
        name: "",
        author: 1,
        categories: "",
        availableCopies:0
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();

        const name = formData.name !== "" ? formData.name : props.books.name;
        const author = formData.author !== 1 ? formData.author : props.books.author.id;
        const categories = formData.categories !== "" ? formData.categories : props.books.categories;
        const availableCopies = formData.availableCopies !== 0 ? formData.availableCopies : props.books.availableCopies;


        props.onEditBook(props.books.id,name, author, categories, availableCopies);
        history.push("/books");
    }

    return (
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Name</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               placeholder={props.books.name}
                               onChange={handleChange}
                        />
                    </div>

                    <div className="form-group">
                        <label htmlFor="availableCopies">Available Copies</label>
                        <input type="text"
                               className="form-control"
                               id="availableCopies"
                               name="availableCopies"
                               placeholder={props.books.availableCopies}
                               onChange={handleChange}
                        />
                    </div>



                    <div className="form-group">
                        <label>Category</label>
                        <select name="categories" className="form-control" onChange={handleChange}>
                            {props.categories.map((term) => {
                              return  <option value={term.valueOf()}>{term.valueOf()}</option>

                            })}

                        </select>
                    </div>
                    <div className="form-group">
                        <label>Author</label>
                        <select name="author" className="form-control" onChange={handleChange}>
                            {props.author.map((term) => {

                                    return <option value={term.id}>{term.name}</option>

                            })}
                        </select>
                    </div>
                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    )
}

export default BooksEdit;
