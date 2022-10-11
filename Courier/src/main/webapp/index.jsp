<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>EKart</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="styles/styles.css" />
    <style>
      input {
        all: unset;
        height: 35px;
      }
      a {
        pointer-events: none;
      }
      #myForm {
        padding-top: 250px;
      }
      a {
        pointer-events: all;
        text-decoration: none;
      }
      .registration-link {
        padding-left: 128px;

        padding-top: 20px;
      }
      .dropdown {
  width: 106.5%;
  height:48px;
}
.dropdown-toggle {
  cursor: pointer;
}
    </style>

    <script
      src="https://code.jquery.com/jquery-3.6.0.min.js"
      integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
      crossorigin="anonymous"
    ></script>
  </head>

  <body>
    <div id="myNav"></div>
    <div class="container">
      <h2 class="mb-5" style="text-align: center;">Welcome to E-kart</h2>

      <div class="row">
        <div class="col-md-4 offset-md-4 login-form" id="myForm">
          <form method="post" action="Calculate">
            <div class="form-group mb-3">
              <label for="username" class="form-label">Customer Name</label>

              <input
                type="text"
                class="form-control"
                id="name"
                name="data-username"
              />
              <label for="username" class="form-label">Mobile number</label>

              <input
                type="text"
                class="form-control"
                id="name"
                name="data-mobile"
              />
              <label for="city" class="form-label">From City</label>
              <select  id="fromCity" class="form-select dropdown" name="data-fromCity"
              >
  					<option value="mumbai" selected>Mumbai</option>
  					<option value="bangalore">Bangalore</option>
  					<option value="chennai">Chennai</option>
 					 <option value="kolkata">Kolkata</option>
			   </select>
               <label for="distance" class="form-label">To City</label>
              <select  id="toCity" class="form-select dropdown" name="data-toCity"
              >
  					<option value="mumbai" selected>Mumbai</option>
  					<option value="bangalore">Bangalore</option>
  					<option value="chennai">Chennai</option>
 					 <option value="kolkata">Kolkata</option>
			   </select>
               <label for="weight" class="form-label">Weight(In Grams)</label>
              <input
                type="number"
                class="form-control"
                id="weight"
               	name="data-weight"
              />
            </div>
            <div class="col-md-2 offset-md-5">
              <button type="submit" class="btn btn-success" >
                Calculate
              </button>
            </div>
          
          </form>
        </div>
      </div>
    </div>


    <script>
      $(function () {
        $('#myNav').load('nav.html')
      })
     
    </script>
  </body>
</html>
