<template>
  <div id="footer">
    <div id="footer-contents">
      <img id="dev-logo" src="..\public\devengers_white.png">
      <ul id="dev-list">
        <div>
          <li id="developed-by">Site updated and maintained by:</li>
          <li id="linkedin-nav"><a id="linkedin-link" href="https://www.linkedin.com/in/maxwell-macfarlane/"><img id="linkedin-logo" src="..\public\linkedin-logo.png"/>Maxwell MacFarlane</a></li>
        </div>
        <div>
          <li id="capstone-team">Capstone Team Members:</li>
          <li id="capstone-members">Herman Grewal, Robin Kim, David Sensendorf, Justin Wagner</li>
        </div>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: 'the-footer'
}
</script>

<style>

#footer {
  display: flex;
  flex-direction: column;
  background-color: #012136;
  text-align: center;
}

ul {
  list-style: none;
}

#dev-list {
  color: white;
  font-family: 'Montserrat', Helvetica, sans-serif;
}

#developed-by {
  font-weight: 700;
}

#linkedin-nav {
  margin-bottom: .5rem;
  font-size: 1.5rem;
}

#linkedin-logo {
  height: 2rem;
  margin-right: .2rem;
  padding-top: 12px;
}

a, a:hover, a:visited, a:active {
  color: rgb(31, 144, 236);
}

#capstone-team {
  font-weight: 600;
  font-size: .85rem;
}

#capstone-members {
  margin: .3rem .3rem 1.5rem .3rem;
  font-size: .7rem;
}

@media only screen and (min-width: 750px) {
  #footer-contents {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    margin: 1rem 0rem 1rem 3rem;
  }

  #dev-list {
    display: flex;
    align-items: center;
    justify-content: space-evenly;
  }

  #dev-list li {
    margin-left: 3rem;
    margin-right: 3rem;
    list-style: none;
  }
}

@media screen and (min-width: 1240px) {
  #capstone-members {
    font-size: 1rem;
  }
}

</style>
