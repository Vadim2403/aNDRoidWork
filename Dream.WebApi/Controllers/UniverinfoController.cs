using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Dream.WebApi.Entities;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace Dream.WebApi.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class UniverinfoController : ControllerBase
    {
        
        private readonly EFContext _context;
        public UniverinfoController(EFContext context)
        {
            _context = context;
        }
        // GET: api/Univerinfo
        [HttpGet]
        public IActionResult Get()
        {
            var list = _context.Universities.ToList();
            return Ok(list);
        }

        // GET: api/Univerinfo/5
        [HttpGet("{id}", Name = "Get")]
        public string Get(int id)
        {
            return "value";
        }

        // POST: api/Univerinfo
        [HttpPost]
        public void Post([FromBody] string value)
        {
        }

        // PUT: api/Univerinfo/5
        [HttpPut("{id}")]
        public void Put(int id, [FromBody] string value)
        {
        }

        // DELETE: api/ApiWithActions/5
        [HttpDelete("{id}")]
        public void Delete(int id)
        {
        }
    }
}
