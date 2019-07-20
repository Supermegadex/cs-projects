/**
 * Draw the circle that comprises the face of the clock.
 * @param ctx {CanvasRenderingContext2D}
 * @param center {[number, number]}
 * @param radius {number}
 */
let drawFace = (ctx, center, radius) => {
  ctx.fillStyle = "#000";
  ctx.strokeStyle = "#000";
  ctx.lineWidth = 10;
  ctx.beginPath();
  ctx.ellipse(center[0], center[1], radius, radius, 0, 0, 2 * Math.PI);
  ctx.stroke();
};

/**
 * Draw the numbers around the edge of the clock face
 * @param ctx {CanvasRenderingContext2D}
 * @param center {[number, number]}
 * @param radius {number}
 */
let drawNumbers = (ctx, center, radius) => {
  ctx.fillStyle = "#000";
  ctx.strokeStyle = "#000";
  ctx.lineWidth = 10;

  const numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12];
  const w = Math.PI / 6;

  for (let num of numbers) {
    const measure = ctx.measureText(num.toString());
    const x = ((radius - 50) * Math.cos(w * (num - 3))) - (measure.width / 2) + center[0];
    const y = ((radius - 50) * Math.sin(w * (num - 3))) + 18 + center[1];
    ctx.fillText(num.toString(), x, y);
  }
};

/**
 * Draws hour hand on clock face
 * @param ctx {CanvasRenderingContext2D}
 * @param center {[number, number]}
 * @param radius {number}
 * @param hour {number}
 * @param minute {number}
 */
let drawHourHand = (ctx, center, radius, hour, minute) => {
  const w = Math.PI / 6;
  const angleToNumber = -w * (3 - (hour + (minute / 60)));
  ctx.beginPath();
  ctx.moveTo(...center);
  const y = (radius / 2) * Math.sin(angleToNumber) + center[0];
  const x = (radius / 2) * Math.cos(angleToNumber) + center[1];
  ctx.lineTo(x, y);
  ctx.stroke();
};

/**
 * Draws minute hand on clock face
 * @param ctx {CanvasRenderingContext2D}
 * @param center {[number, number]}
 * @param radius {number}
 * @param minute {number}
 * @param second {number}
 */
let drawMinuteHand = (ctx, center, radius, minute, second) => {
  const w = Math.PI / 30;
  const angleToNumber = -w * (15 - (minute + (second / 60)));
  ctx.beginPath();
  ctx.moveTo(...center);
  const y = (2 * radius / 3) * Math.sin(angleToNumber) + center[0];
  const x = (2 * radius / 3) * Math.cos(angleToNumber) + center[1];
  ctx.lineTo(x, y);
  ctx.stroke();
};

/**
 * Draws second hand on clock face
 * @param ctx {CanvasRenderingContext2D}
 * @param center {[number, number]}
 * @param radius {number}
 * @param second {number}
 */
let drawSecondHand = (ctx, center, radius, second) => {
  ctx.lineWidth = 4;
  const w = Math.PI / 30;
  const angleToNumber = -w * (15 - (second));
  ctx.beginPath();
  ctx.moveTo(...center);
  const y = (2 * radius / 3) * Math.sin(angleToNumber) + center[0];
  const x = (2 * radius / 3) * Math.cos(angleToNumber) + center[1];
  ctx.lineTo(x, y);
  ctx.stroke();
};

/**
 * Loop
 * @param ctx {CanvasRenderingContext2D}
 * @param probability {number}
 */
let loop = (ctx, probability) => {
  const width = 800;
  const height = 800;
  const time = new Date();

  ctx.fillStyle = "#fff";
  ctx.font = "48px sans-serif";
  ctx.lineCap = "round";
  ctx.fillRect(0, 0, window.innerWidth, window.innerHeight);

  const center = [width / 2, height / 2];
  const radius = Math.min(...center) - 50;
  drawFace(ctx, center, radius);
  drawNumbers(ctx, center, radius);
  drawHourHand(ctx, center, radius, time.getHours(), time.getMinutes());
  drawMinuteHand(ctx, center, radius, time.getMinutes(), time.getSeconds());
  drawSecondHand(ctx, center, radius, time.getSeconds());
  requestAnimationFrame(() => loop(ctx, probability + 0.01));
};

loop(document.querySelector('canvas').getContext('2d'), 100);
