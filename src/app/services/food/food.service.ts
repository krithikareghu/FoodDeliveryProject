import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class FoodService {

  private allcategoryurl = "http://localhost:8080/allcategory"
  private categorydetails = "http://localhost:8080/findAllcategories"

  constructor(private http: HttpClient) { }







  getcategorydetails() {
    return this.http.get(this.categorydetails);
  }
}

  // getfoodbysearchfilter(searchfilter:string){
  //   return this.getall().filter(food=>
  //     food.categoryname.toLowerCase().includes(searchfilter.toLowerCase()));


  // }
  

//   Items=[ {itemname: 'Noodles',itemprice: 150,itemurl: '/assets/images/Italian.jpg'}, 
//   { itemname: 'Icecreams',itemprice: 250, itemurl: '/assets/images/Icecreams.jpg'}
// ]
//   getall() {
//   return [ 
//       {
//         id: 1,
//         categoryname: 'Bakery',
//         categoryurl: '/assets/images/Bakery.jpg',
//         Restaurant: [
//           {
//             restaurantname: 'Adyar ananda bhavan',
//             restaurantcontact: '836238272',
//             Items:[ {
              
//                 itemname: 'Noodles',
//                 itemprice: 150,
//                 itemurl: '/assets/images/Italian.jpg'

//               }, {
//                 itemname: 'Icecreams',
//                 itemprice: 250,
//                 itemurl: '/assets/images/Icecreams.jpg'
//               }
//             ]
//           },{
//             restaurantname: 'Food truck',
//             restaurantcontact: '836238272',
//             Items:[ {
              
//                 itemname: 'Icecream',
//                 itemprice: 150,
//                 itemurl: '/assets/images/Italian.jpg'

//               }, {
//                 itemname: 'Icecreams',
//                 itemprice: 200,
//                 itemurl: '/assets/images/Icecreams.jpg'
//               }
//             ]
//           }
//           ,{
//             restaurantname: 'Gupta Bavan',
//             restaurantcontact: '836238272',
//             Items:[ {
              
//                 itemname: 'Icecream',
//                 itemprice: 150,
//                 itemurl: '/assets/images/Italian.jpg'

//               }, {
//                 itemname: 'Cakes',
//                 itemprice: 250,
//                 itemurl: '/assets/images/Icecreams.jpg'
//               }
//             ]
//           }
        
//         ]
//       },{
//         id: 2,
//         categoryname: 'Italian',
//         categoryurl: '/assets/images/Chinese.jpg',
//         Restaurant: [
//           {
//             restaurantname: 'Bakery Restaurant',
//             restaurantcontact: '836238272',
//             Items: [
//               {
//                 itemname: 'Milkshake',
//                 itemprice: 150,
//                 itemurl: '/assets/images/.jpg'

//               }, {
//                 itemname: 'Cakes',
//                 itemprice: 250,
//                 itemurl: '/assets/images/.jpg'
//               }]
//           }


//         ]


//       },{
//         id: 3,
//         categoryname: 'Icecreams',
//         categoryurl: '/assets/images/Icecreams.jpg',
//         Restaurant: [
//           {
//             restaurantname: '',
//             restaurantcontact: '836238272',
//             Items: [
//               {
//                 itemname: '',
//                 itemprice: 150,
//                 itemurl: '/assets/images/.jpg'

//               }, {
//                 itemname: '',
//                 itemprice: 250,
//                 itemurl: '/assets/images/.jpg'
//               }]
//           }


//         ]


//       },{
//         id: 4,
//         categoryname: 'Breakfast',
//         categoryurl: '/assets/images/Breakfast.jpg',
//         Restaurant: [
//           {
//             restaurantname: 'adyar ananda bhavan',
//             restaurantcontact: '836238272',
//             Items: [
//               {
//                 itemname: 'Icecream',
//                 itemprice: 150,
//                 itemurl: '/assets/images/Icecreams.jpg'

//               }, {
//                 itemname: 'Cakes',
//                 itemprice: 250,
//                 itemurl: '/assets/images/Icecreams.jpg'
//               }]
//           }


//         ]


//       },{
//         id: 5,
//         categoryname: 'Lunch',
//         categoryurl: '/assets/images/Lunch.jpg',
//         Restaurant: [
//           {
//             restaurantname: 'adyar ananda bhavan',
//             restaurantcontact: '836238272',
//             Items: [
//               {
//                 itemname: 'Icecream',
//                 itemprice: 150,
//                 itemurl: '/assets/images/Icecreams.jpg'

//               }, {
//                 itemname: 'Cakes',
//                 itemprice: 250,
//                 itemurl: '/assets/images/Icecreams.jpg'
//               }]
//           }


//         ]


//       },{
//         id: 6,
//         categoryname: 'Italian',
//         categoryurl: '/assets/images/Dinner.jpg',
//         Restaurant: [
//           {
//             restaurantname: 'adyar ananda bhavan',
//             restaurantcontact: '836238272',
//             Items: [
//               {
//                 itemname: 'Icecream',
//                 itemprice: 150,
//                 itemurl: '/assets/images/Icecreams.jpg'

//               }, {
//                 itemname: 'Cakes',
//                 itemprice: 250,
//                 itemurl: '/assets/images/Icecreams.jpg'
//               }]
//           }


//         ]


//       }
    
  
//     ]
//   }







// }
